package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Integer idUser) {

        return userRepository.findById(idUser);

    }

    @Override
    public Optional<User> getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    @Override
    public User updateUser(User user) {


        Optional<User> existingUser = userRepository.findById(user.getIdUser());

        return existingUser.map(value -> kaka(value, user)).orElse(null);
    }

    private User kaka(User existingUser , User user) {

        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);

    }

    @Override
    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }
}
