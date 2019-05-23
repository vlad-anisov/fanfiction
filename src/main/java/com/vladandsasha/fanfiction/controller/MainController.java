package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String main(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("")
    public String add(Model model, @RequestParam String username){
        userRepository.save(new User(username));
        model.addAttribute("users",userRepository.findAll());
        return "main";
    }
}
