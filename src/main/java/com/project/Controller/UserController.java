package com.project.Controller;

import com.project.JWT.JWTUtil;
import com.project.Models.User.UserDTO;
import com.project.Models.User.UserRegistrationRequest;
import com.project.Models.User.UserServiceImpl;
import com.project.Models.User.UserUpdateRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserServiceImpl userService;
    private JWTUtil jwtUtil;

    public UserController(UserServiceImpl userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request){
        userService.addUser(request);

        String token = jwtUtil.issueToken(request.email(), "ROLE_USER");

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,token)
                .build();
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
