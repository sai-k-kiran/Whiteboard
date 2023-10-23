package com.project.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Integer id);
    public void addUser(UserRegistrationRequest request);
    public void removeUser(Integer id);
    public void updateUser(Integer id, UserUpdateRequest request);
}
