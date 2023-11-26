package com.project.Models.Images;

import com.project.Models.User.User;
import org.springframework.web.multipart.MultipartFile;

public record ImageCreationRequest(
        MultipartFile file,
        Integer user_id
) {
}