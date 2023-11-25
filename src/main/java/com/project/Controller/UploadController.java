package com.project.Controller;

import com.project.Models.Design.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/storage")
public class UploadController {

    private AmazonClient amazonClient;

    @Autowired
    UploadController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}
