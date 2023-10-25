package com.project.auth;

import com.project.Models.User.UserDTO;

public record AuthenticationResponse(
        String token,
        UserDTO userDTO
) {
}
