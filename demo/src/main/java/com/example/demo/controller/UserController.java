package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }



    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId){
        Optional<User> user = userService.getUserById(userId);

        return user.map( user1 -> new ResponseEntity<>(user1, HttpStatus.OK))
                .orElseGet( () -> new ResponseEntity<>(new User(),HttpStatus.NOT_FOUND)) ;
    }

    // Método para obtener un usuario por email y contraseña
    @PostMapping("/login") // Cambié la anotación a PostMapping porque estás enviando la información en el cuerpo de la solicitud
    public ResponseEntity<User> getUserByEmailAndPassword(@RequestBody User userRequest){ // Aquí recibimos el objeto User en el cuerpo de la solicitud
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();

        Optional<User> user = userService.getUserByEmail(email);



        if(user.isPresent() && user.get().getPassword().equals(password)){ // Verificamos si el usuario existe y si la contraseña es correcta

            System.out.println("EMAIL ========="+user.get().getEmail());
            System.out.println("PASSWORD ========="+user.get().getPassword());

            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer idUser,
                                           @RequestBody User user){
        /*user.setId(idUser);
        User updatedUser = userService.updateUser(user);*/
        return null;

    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
