package com.asociadosct.ecommerceproducts.controller;

import com.asociadosct.ecommerceproducts.entity.User;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;
import com.asociadosct.ecommerceproducts.repository.ProfileRepository;
import com.asociadosct.ecommerceproducts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
public class UserController<T> {

    private static final String NOT_FOUND_USER_MESSAGE = "No se encuentra el usuario con el ID :: ";
    private static final String USER_SUCCESSFUL = "Se crea el usuario correctamente.";

    @Autowired
    UserService userService;

    @Autowired
    ProfileController profileController;


    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getProfile(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userService.getUser(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_USER_MESSAGE + id));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<T> createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<T>((T) USER_SUCCESSFUL, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    //@Valid se encarga de revisar si las validaciones de la clase se cumplen
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
                                           @Valid @RequestBody User userParam)
            throws ResourceNotFoundException {
        User user = userService.getUser(userId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_USER_MESSAGE + userId));
        user.setUsername(userParam.getUsername());
        user.setPassword(user.getPassword());
        // Toca revisar como actualizar la tabla intermedia

        final User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userService.getUser(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_USER_MESSAGE + id));

        this.userService.deleteUser(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}