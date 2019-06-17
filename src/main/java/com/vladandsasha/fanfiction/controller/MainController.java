package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.FanficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private FanficRepository fanficRepository;

    @GetMapping("")
    public String main(Model model,@RequestParam(required = false, defaultValue = "") String search){
        model.addAttribute("fanfics",fanficRepository.findAll());
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
