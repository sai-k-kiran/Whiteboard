package com.project.Models.User;

import java.util.List;

public record UserDTO(
        Integer id,
        String name,
        String email,
        String companyName,
        String phoneNum,
        String location
//        List<String> roles
//        String username
) {
}
