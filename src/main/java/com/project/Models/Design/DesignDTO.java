package com.project.Models.Design;

import com.project.Models.User.User;

public record DesignDTO(
        Integer designId,
        String design,
        User userId
) {
}
