package com.asociadosct.ecommerceproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.asociadosct.ecommerceproducts.entity.User;
import com.asociadosct.ecommerceproducts.service.IUserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> create(@RequestBody User user) {
    	userService.create(user);
        return new ResponseEntity("Se crea el usuario correctamente.", HttpStatus.CREATED);
    }
}