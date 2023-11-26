package com.project.Models.Images;

import com.project.Models.User.User;

public record ImageUploadRequest(
        String imageUrl,
        User user
) {
}
