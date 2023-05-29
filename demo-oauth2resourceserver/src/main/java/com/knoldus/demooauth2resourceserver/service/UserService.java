package com.knoldus.demooauth2resourceserver.service;

import com.knoldus.demooauth2resourceserver.model.User;
import com.knoldus.demooauth2resourceserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public Optional<User> getUserById(int id){
        return repository.findById(id);
    }
}
