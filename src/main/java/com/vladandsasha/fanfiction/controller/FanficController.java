package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.repository.FanficRepository;
import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.service.FanficService;
import com.vladandsasha.fanfiction.service.SecurityService;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("fanfic/")
public class FanficController {
    @Autowired
    private FanficRepository fanficRepository;

    @Autowired
    private FanficService fanficService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{fanficId}")
    public String fanfic(@AuthenticationPrincipal User user, @PathVariable String fanficId, Model model){
        model.addAttribute("fanfic",fanficRepository.findById(Integer.parseInt(fanficId)));
        if(securityService.fanfic(user, fanficId))
            model.addAttribute("edit", true);
        return "fanfic";
    }

    @GetMapping("new")
    public String newFanfic(){
        return "addFanfic";
    }

    @PostMapping("new")
    public String addNewFanfic(@AuthenticationPrincipal User user, @RequestParam String title, @RequestParam String description,
                               @RequestParam String genre, @RequestParam String tag, @RequestParam MultipartFile image){
        Fanfic fanfic = fanficService.addNewFanfic(user, title, description, genre, tag, image);
        return "redirect:/fanfic/" + fanfic.getId() + "/chapter/new";
    }

    @GetMapping("{username}/new")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String newFanficUser(){
        return "addFanficUser";
    }

    @PostMapping("{username}/new")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String addNewFanficUser(@PathVariable String username, @RequestParam String title, @RequestParam String description,
                               @RequestParam String genre, @RequestParam String tag, @RequestParam MultipartFile image){
        User user = userRepository.findByUsername(username);
        return addNewFanfic(user, title, description, genre, tag, image);
    }

    @GetMapping("{fanficId}/edit")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String fanficEdit(@PathVariable String fanficId, Model model){
        model.addAttribute("fanfic",fanficRepository.findById(Integer.parseInt(fanficId)));
        model.addAttribute("genre",fanficRepository.findById(Integer.parseInt(fanficId)).getGenre().name());
        return "fanficEdit";
    }

    @PostMapping("{fanficId}/edit")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String fanficSave(@PathVariable String fanficId, @RequestParam String title, @RequestParam String description,
                             @RequestParam String genre, @RequestParam String tag, @RequestParam MultipartFile image){
        fanficService.save(fanficId, title, description, genre, tag, image);
        return "redirect:/fanfic/" + fanficId;
    }

    @GetMapping("{fanficId}/delete")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String fanficDelete(@PathVariable String fanficId){
        Fanfic fanfic = fanficRepository.findById(Integer.parseInt(fanficId));
        fanficRepository.delete(fanfic);
        return "redirect:/user/" + fanfic.getUser().getUsername();
    }
}
