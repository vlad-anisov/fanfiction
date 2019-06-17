package com.vladandsasha.fanfiction.service;

import com.vladandsasha.fanfiction.fanfics.Chapter;
import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.repository.ChapterRepository;
import com.vladandsasha.fanfiction.repository.FanficRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private FanficRepository fanficRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private SecurityService securityService;

    public Chapter addNewChapter(String id, String title, MultipartFile image, String text) {
        Fanfic fanfic = fanficRepository.findById(Integer.parseInt(id));
        Chapter chapter = new Chapter(title, imageService.img(image), text);
        fanfic.addChapters(chapter);
        chapterRepository.save(chapter);
        return chapter;
    }

    public void save(String id, String title, MultipartFile image, String text) {
        Chapter chapter = chapterRepository.findById(Integer.parseInt(id));
        chapter.setTitle(title);
        chapter.setText(text);
        if(!image.isEmpty())
            chapter.setImage(imageService.img(image));
        chapterRepository.save(chapter);
    }

    public void chapter(User user, String fanficId, String chapterId, Model model) {
        Chapter chapter = chapterRepository.findById(Integer.parseInt(chapterId));
        model.addAttribute("chapter", chapter);
        ArrayList<Chapter> chapters = new ArrayList(fanficRepository.findById(Integer.parseInt(fanficId)).getChapters());
        if(securityService.fanfic(user,chapter.getFanfic().getId().toString()))
            model.addAttribute("edit", true);
        if(chapters.size() == 1) return;
        else chapterPage(chapter, chapters, model);
    }

    private void chapterPage(Chapter chapter, ArrayList<Chapter> chapters, Model model) {
        int index = chapters.indexOf(chapter);
        if (index == 0)
            model.addAttribute("next", chapters.get(1).getId());
        else if (index == chapters.size() - 1)
            model.addAttribute("previous",chapters.get(index - 1).getId());
        else {
            model.addAttribute("previous",chapters.get(index - 1).getId());
            model.addAttribute("next", chapters.get(index + 1).getId());
        }
    }
}
