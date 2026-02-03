package com.example.demo.service;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageLinkDai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Utilities;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.UUID;

@Service
public class S3Service {
    @Autowired
    ImageLinkDai imgRepo;
    private final S3Client s3Client = S3Client.builder().region(Region.EU_NORTH_1).build();
    private final String bucketName = "storekeeper-denzhe";
    public void uploadFile(String fileName, byte[] content, String contentType,int id){
        String key = UUID.randomUUID() + "-" +fileName;
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(contentType)
                .build();
        S3Utilities util = s3Client.utilities();
        String url = util.getUrl(builder -> builder.bucket(bucketName).key(key)).toString();
        s3Client.putObject(request, RequestBody.fromBytes(content));

        imgRepo.save(new Image(id,url));
    }
}
