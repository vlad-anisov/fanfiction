package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.Role;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class SignUpController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("message","");
        return "signup";
    }

    @PostMapping("/signup")
    public String add(User user, Model model){
        if(checkUserAndPassword(user) || userRepository.findByUsername(user.getUsername()) != null){
            model.addAttribute("message","User exists");
            return "signup";
        }
        else {
            user.setActive(true);
            user.setRole(Collections.singleton(Role.USER));
            userRepository.save(user);
            return "redirect:/login";
        }
    }

    private boolean checkUserAndPassword(User user){
        if(user.getUsername() == "" || user.getPassword() == "")
            return true;
        else
            return false;
    }

}
