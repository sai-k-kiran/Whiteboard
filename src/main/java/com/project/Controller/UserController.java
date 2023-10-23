package com.project.Controller;

import com.project.Models.User.UserDTO;
import com.project.Models.User.UserRegistrationRequest;
import com.project.Models.User.UserServiceImpl;
import com.project.Models.User.UserUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDTO getCustomers(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest request){
        userService.addUser(request);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.removeUser(id);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserUpdateRequest request){
        userService.updateUser(id, request);
    }
}
