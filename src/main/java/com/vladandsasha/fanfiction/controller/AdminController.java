package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.Role;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String admin(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "admin";
    }

    @PostMapping("assignAdmin")
    public String assignAdmin(@RequestParam("id") User user){
        user.getRole().clear();
        user.getRole().add(Role.ADMIN);
        userRepository.save(user);
        return "redirect:/admin";
    }

    @PostMapping("block")
    public String block(@RequestParam("id") User user){
        user.setActive(!user.isActive());
        userRepository.save(user);
        return "redirect:/admin";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("id") User user){
        userRepository.delete(user);
        return "redirect:/admin";
    }
}
