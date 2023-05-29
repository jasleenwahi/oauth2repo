package com.knoldus.demooauth2resourceserver.controller;

import com.knoldus.demooauth2resourceserver.model.User;
import com.knoldus.demooauth2resourceserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/showusers")
    public List<User> showAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/showuser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/api/auth/success")
    public String returnString(){
        return "Success";
    }

    @GetMapping("/")
    public String returnStringl(){
        return "Logout";
    }
}


