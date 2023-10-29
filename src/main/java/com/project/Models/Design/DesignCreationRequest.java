package com.project.Models.Design;

import com.project.Models.User.User;

public record DesignCreationRequest(
        String design,
        User user
) {
}
