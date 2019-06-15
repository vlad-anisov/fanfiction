package com.vladandsasha.fanfiction.service;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.repository.FanficRepository;
import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SecurityService {
    @Autowired
    private FanficRepository fanficRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean fanfic(User user, String fanficId){
        if(user == null)
            return false;
        Set<Fanfic> fanfics =userRepository.findByUsername(user.getUsername()).getFanfics();
        Fanfic fanfic = fanficRepository.findById(Integer.parseInt(fanficId));
        if(fanfics.contains(fanfic) || user.isAdmin())
            return true;
        else
            return false;
    }

    public boolean user(User user, String username){
        if(user == null)
            return false;
        if(user.getUsername().equals(username) || user.isAdmin())
            return true;
        else
            return false;
    }
}
