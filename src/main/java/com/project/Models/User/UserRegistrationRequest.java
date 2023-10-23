package com.project.Models.User;

public record UserRegistrationRequest(
        String name,
        String email,
        String companyName,
        String phoneNum,
        String location,
        String password
) {
}

