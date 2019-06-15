package com.vladandsasha.fanfiction.users;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "fanfics")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private boolean active;
    private String email;
    private String activationCode;
    private boolean darkMode;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Fanfic> fanfics;

    public boolean isAdmin(){
        if(role.contains(Role.ADMIN))
            return true;
        else
            return false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    public User() {
    }

    public void addFanfic(Fanfic fanfic){
        this.fanfics = Stream.of(fanfic).collect(Collectors.toSet());
        this.fanfics.forEach(x -> x.setUser(this));
    }
}
