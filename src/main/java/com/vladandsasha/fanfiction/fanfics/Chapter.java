package com.vladandsasha.fanfiction.fanfics;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Chapter{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String image;
    @Type(type="text")
    private String text;
    @ManyToOne
    @JoinColumn
    private Fanfic fanfic;

    public Chapter(String title, String image, String text) {
        this.title = title;
        this.image = image;
        this.text = text;
    }

    public Chapter(){}

    public String getMarkdownText(){
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(text);
        return renderer.render(document);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return id.equals(chapter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
