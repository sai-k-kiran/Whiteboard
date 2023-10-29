package com.project.Models.Design;

import com.project.Models.User.User;

public record DesignDTO(
        Integer design_id,
        String design,
        User user_id
) {
}
