package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageLinkDai;
import com.example.demo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    S3Service s3Service;
    @Autowired
    ImageLinkDai imgService;

    @PostMapping("/upload-image/{id}")
    public void uploadImage(@PathVariable int id, @RequestPart MultipartFile image){
        byte[] img = null;
        try {
            img = image.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        s3Service.uploadFile(image.getOriginalFilename(),img,image.
                getContentType(),id);
    }
    @GetMapping("/image-link/{id}")
    public String getLink(@PathVariable int id){
        return imgService.findById(id).get().getUrl();
    }
}
