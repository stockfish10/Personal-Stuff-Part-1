package com.TestApp.web;

import com.TestApp.model.entities.UserEntity;
import com.TestApp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    public UserEntity newUser(@RequestBody UserEntity newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
