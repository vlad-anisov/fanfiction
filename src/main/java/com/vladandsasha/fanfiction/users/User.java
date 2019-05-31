package com.vladandsasha.fanfiction.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

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

    public boolean isAdmin(){
        return role.contains(Role.ADMIN);
    }

    public boolean getAdmin(){
        if(role.contains(Role.ADMIN))
            return true;
        else
            return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public User(String username) {
        this.username = username;
        this.darkMode = false;
        this.role = Collections.singleton(Role.USER);
        this.active = false;
        this.activationCode = UUID.randomUUID().toString();
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }
}
