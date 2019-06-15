package com.vladandsasha.fanfiction.controller;

import com.vladandsasha.fanfiction.fanfics.Chapter;
import com.vladandsasha.fanfiction.repository.ChapterRepository;
import com.vladandsasha.fanfiction.service.ChapterService;
import com.vladandsasha.fanfiction.service.SecurityService;
import com.vladandsasha.fanfiction.users.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fanfic/{fanficId}/")
public class ChapterController {
    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    ChapterService chapterService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("chapter/{chapterId}")
    public String chapter(@AuthenticationPrincipal User user, @PathVariable String fanficId, @PathVariable String chapterId, Model model){
        chapterService.chapter(user,fanficId,chapterId, model);
        return "chapter";
    }

    @GetMapping("chapter/new")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String newChapter(@PathVariable String fanficId){
        return "addChapter";
    }

    @PostMapping("chapter/new")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String addNewChapter(@PathVariable String fanficId, @RequestParam String title,
                                @RequestParam MultipartFile image, @RequestParam String text){
        Chapter chapter = chapterService.addNewChapter(fanficId, title, image, text);
        return "redirect:/fanfic/" + fanficId + "/chapter/" + chapter.getId();
    }

    @GetMapping("chapter/{chapterId}/edit")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String chapterEdit(@PathVariable String fanficId, @PathVariable String chapterId, Model model){
        model.addAttribute("chapter",chapterRepository.findById(Integer.parseInt(chapterId)));
        return "chapterEdit";
    }

    @PostMapping("chapter/{chapterId}/edit")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String chapterSave(@PathVariable String fanficId, @PathVariable String chapterId, @RequestParam String title,
                              @RequestParam MultipartFile image, @RequestParam String text){
        chapterService.save(chapterId, title, image, text);
        return "redirect:/fanfic/" + fanficId + "/chapter/" + chapterId;
    }

    @GetMapping("chapter/{chapterId}/delete")
    @PreAuthorize("@securityService.fanfic(principal,#fanficId)")
    public String chapterDelete(@PathVariable String fanficId, @PathVariable String chapterId){
        chapterRepository.delete(chapterRepository.findById(Integer.parseInt(chapterId)));
        return "redirect:/fanfic/" + fanficId;
    }
}
