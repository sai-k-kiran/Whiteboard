package com.project.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    public List<User> selectAllUsers();
    public Optional<User> selectUserById(Integer id);
    public void registerUser(User user);
    public void deleteUserById(Integer id);
    public void updateUser(User user);

    public boolean emailExists(String email);
    public boolean idExists(Integer id);

    public Optional<User> selectUserByEmail(String email);
}
