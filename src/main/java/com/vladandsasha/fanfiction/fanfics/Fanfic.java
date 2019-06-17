package com.vladandsasha.fanfiction.fanfics;

import com.vladandsasha.fanfiction.users.User;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Entity
public class Fanfic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Type(type="text")
    private String description;
    private Genre genre;
    @ElementCollection
    private Set<String> tag;
    private String image;

    @OneToMany(mappedBy = "fanfic", cascade = CascadeType.ALL)
    private Set<Chapter> chapters;
    //private Set<Comment> comment;

    @ManyToOne
    @JoinColumn
    private User user;

    public Fanfic(String title, String description, Genre genre, Set<String> tag, String image, User user) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.tag = tag;
        this.image = image;
        this.user = user;
    }

    public Fanfic(){}

    public void addChapters(Chapter chapter){
        this.chapters = Stream.of(chapter).collect(Collectors.toSet());
        this.chapters.forEach(x -> x.setFanfic(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fanfic fanfic = (Fanfic) o;
        return id.equals(fanfic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
