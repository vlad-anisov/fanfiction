package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.service.SecurityService;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/{username}")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @GetMapping("")
    public String UserPage(@AuthenticationPrincipal User user, @PathVariable String username, Model model){
        model.addAttribute("userProfile",userRepository.findByUsername(username));
        if(securityService.user(user,username))
            model.addAttribute("edit", true);
        return "user";
    }

    @GetMapping("edit")
    @PreAuthorize("@securityService.user(principal, #username)")
    public String Edit(@PathVariable String username, Model model){
            model.addAttribute("user",userRepository.findByUsername(username));
            return "userEdit";
    }

    @PostMapping("save")
    @PreAuthorize("@securityService.user(principal, #username)")
    public String Save(@AuthenticationPrincipal User user,@PathVariable String username,
                           @RequestParam String newUsername, @RequestParam(required = false) boolean  darkMode, Model model){
        if(!userRepository.findByUsername(username).getUsername().equals(newUsername) && userRepository.findByUsername(newUsername) != null){
            model.addAttribute("message",false);
            return Edit(username,model);
        }
        else {
            User userEdit = userRepository.findByUsername(username);
            userEdit.setUsername(newUsername);
            userEdit.setDarkMode(darkMode);
            userRepository.save(userEdit);
            if(user.getUsername().equals(username)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(userEdit, userEdit.getPassword(), userEdit.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            model.addAttribute("message",true);
            //return "redirect:/user/" + newUsername + "/edit";
            return Edit(newUsername,model);
        }
    }

    @PostMapping("delete")
    @PreAuthorize("@securityService.user(principal, #username)")
    public String Delete(@PathVariable String username){
        userRepository.delete(userRepository.findByUsername(username));
        return "redirect:/logout";
    }
}
