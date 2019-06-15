package com.vladandsasha.fanfiction.service;

import com.vladandsasha.fanfiction.fanfics.Fanfic;
import com.vladandsasha.fanfiction.fanfics.Genre;
import com.vladandsasha.fanfiction.repository.FanficRepository;
import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class FanficService {
    @Autowired
    private FanficRepository fanficRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserRepository userRepository;

    public Fanfic addNewFanfic(User user, String title, String description, String genre, String tag, MultipartFile image) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        Fanfic fanfic = new Fanfic(title, description, Genre.valueOf(genre), new HashSet<>(Arrays.asList(tag.split("\\s*,\\s*"))), imageService.img(image), userFromDB);
        userFromDB.addFanfic(fanfic);
        fanficRepository.save(fanfic);
        return fanfic;
    }

    public void save(String fanficId, String title, String description, String genre, String tag, MultipartFile image) {
    Fanfic fanfic = fanficRepository.findById(Integer.parseInt(fanficId));
    fanfic.setTitle(title);
    fanfic.setDescription(description);
    fanfic.setGenre(Genre.valueOf(genre));
    fanfic.setTag(new HashSet<>(Arrays.asList(tag.split("\\s*,\\s*"))));
    if(!image.isEmpty())
        fanfic.setImage(imageService.img(image));
    fanficRepository.save(fanfic);
    }
}
