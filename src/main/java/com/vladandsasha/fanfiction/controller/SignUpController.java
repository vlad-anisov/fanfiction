package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.service.UserService;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String SignUp(){
        return "signup";
    }

    @GetMapping("/activate/{code}")
    public String Activate(@PathVariable String code, Model model){
        userService.activateUser(code, model);
        return "login";
    }

    @PostMapping("/signup")
    public String Add(User user, Model model){
        return userService.addUser(user, model);
    }

}
