package com.example.demo.service;

import com.example.demo.repository.ImageLinkDai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageLinkDai imgRepo;

    public String getImgUrlById(int id){
        return imgRepo.findById(id).get().getUrl();
    }
}
