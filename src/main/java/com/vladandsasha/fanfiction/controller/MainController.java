package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.repository.FanficRepository;
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

    @Autowired
    private FanficRepository fanficRepository;

    @GetMapping("")
    public String main(Model model){
        model.addAttribute("fanfics",fanficRepository.findAll());
        return "main";
    }

    @PostMapping("")
    public String addNewFanfic(Model model, @RequestParam String text, @RequestParam String tag){
        fanficRepository.save(new Fanfic(text, tag));
        model.addAttribute("fanfics",fanficRepository.findAll());
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/admin")
    public String addNewUser(Model model, @RequestParam String username){
        userRepository.save(new User(username));
        model.addAttribute("users",userRepository.findAll());
        return "admin";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "admin";
    }
}
