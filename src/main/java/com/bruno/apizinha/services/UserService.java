package com.bruno.apizinha.services;

import com.bruno.apizinha.entities.User;
import com.bruno.apizinha.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return (List<User>) userRepository.saveAll(users);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();

    }
}