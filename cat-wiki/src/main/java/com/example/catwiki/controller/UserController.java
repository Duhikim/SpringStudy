package com.example.catwiki.controller;

import com.example.catwiki.model.User;
import com.example.catwiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired // or not
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // http://localhost:8080/users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // http://localhost:8080/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
