package com.TestApp.web;

import com.TestApp.exception.UserNotFoundException;
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

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    public UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id){
        return userRepository.findById(id).
                map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).
                orElseThrow(()-> new UserNotFoundException(id));
    }
}
