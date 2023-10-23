package com.project.Models.User;

public record UserUpdateRequest(
        String name,
        String companyName,
        String phoneNum,
        String location
) {
}
