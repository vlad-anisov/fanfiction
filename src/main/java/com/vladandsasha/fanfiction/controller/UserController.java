package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("{user}")
    public String UserPage(){
        return "login";
    }


    @GetMapping("{username}/edit")
    public String Edit(@AuthenticationPrincipal User user, @PathVariable String username, Model model){
        if(user.getUsername().equals(username) || user.getAdmin()){
            model.addAttribute("user",userRepository.findByUsername(username));
            return "userEdit";
        }
        else
            throw new RuntimeException();
    }

    @PostMapping("{username}/save")
    public String Save(@AuthenticationPrincipal User user,@PathVariable String username,
                           @RequestParam("newUsername") String newUsername, @RequestParam(value = "darkMode",required = false) boolean  darkMode, Model model){
        if(!userRepository.findByUsername(username).getUsername().equals(newUsername) && userRepository.findByUsername(newUsername) != null){
            model.addAttribute("message","A user with the same name already exists.");
            return "redirect:/user/" + username + "/edit";
        }
        else {
            User userEdit = userRepository.findByUsername(username);
            userEdit.setUsername(newUsername);
            userEdit.setDarkMode(darkMode);
            userRepository.save(userEdit);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userEdit, userEdit.getPassword(), userEdit.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            model.addAttribute("message","All saved");
            return "redirect:/user/" + newUsername + "/edit";
        }
    }

    @PostMapping("{username}/delete")
    public String Delete(@PathVariable String username){
        userRepository.delete(userRepository.findByUsername(username));
        return "redirect:/logout";
    }
}
