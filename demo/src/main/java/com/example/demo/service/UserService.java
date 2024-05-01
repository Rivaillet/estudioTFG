package com.example.demo.service;


import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(Integer idUser);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Integer idUser);
}