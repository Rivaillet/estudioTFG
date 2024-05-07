package com.example.ProyectoJuanBarberoSerrano.controllers;

import com.example.ProyectoJuanBarberoSerrano.entities.User;
import com.example.ProyectoJuanBarberoSerrano.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor



@CrossOrigin("*")



@RequestMapping("api/users")

public class UserController {

    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    /*@PostMapping("{firstName}")
    public boolean existUser(@PathVariable("firstName") String firstName){


        return userService.getUserByFirstName(firstName);
    }*/

    @GetMapping("/exists/{firstName}")
    public ResponseEntity<String> checkUserExists(@PathVariable("firstName") String firstName) {
        boolean exists = userService.existsByFirstName(firstName);
        if (exists) {

            ResponseEntity re = new ResponseEntity("El usuario existe",HttpStatus.OK);

            return new ResponseEntity<>("El usuario existe", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {

        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
