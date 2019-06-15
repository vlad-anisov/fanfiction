package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.FanficRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private FanficRepository fanficRepository;

    @GetMapping("")
    public String main(@AuthenticationPrincipal User user, Model model,@RequestParam(required = false, defaultValue = "") String search){
        /*if(search != null && !search.isEmpty())
            model.addAttribute("fanfics", fanficRepository.findById(2));
        else
            model.addAttribute("fanfics", fanficRepository.findAll());
        model.addAttribute("search", search);*/
        model.addAttribute("fanfics",fanficRepository.findAll());
        return "main";
    }

   /* @PostMapping("")
    public String addNewFanfic(@AuthenticationPrincipal User user, Model model, @RequestParam String text, @RequestParam String tag){
        fanficRepository.save(new Fanfic(text, tag, user));
        model.addAttribute("fanfics",fanficRepository.findAll());
        return "main";
    }
*/
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
