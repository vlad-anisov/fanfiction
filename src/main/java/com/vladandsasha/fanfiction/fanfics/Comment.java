package com.vladandsasha.fanfiction.fanfics;

import com.vladandsasha.fanfiction.users.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private User user;
    private String text;

    public Comment(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Comment(){}
}