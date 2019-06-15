package com.vladandsasha.fanfiction.service;

import com.cloudinary.utils.ObjectUtils;
import com.vladandsasha.fanfiction.config.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {
    @Autowired
    private CloudinaryConfig cloudinaryConfig;

    public String img(MultipartFile image) {
        String img;
        try {
            Map uploadResult = cloudinaryConfig.upload(image.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            img = uploadResult.get("url").toString();
        } catch (IOException e){
            System.out.println("dadadad");
            e.printStackTrace();
            System.out.println(e);
            throw new RuntimeException();
        }
        return img;
    }
}
