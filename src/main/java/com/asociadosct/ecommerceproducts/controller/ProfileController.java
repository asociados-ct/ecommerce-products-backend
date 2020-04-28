package com.asociadosct.ecommerceproducts.controller;

import com.asociadosct.ecommerceproducts.entity.Profile;
import com.asociadosct.ecommerceproducts.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired
    IProfileService profileService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Profile>> getAll() {
        return new ResponseEntity<>(profileService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> create(@RequestBody Profile profile) {
        profileService.create(profile);
        return new ResponseEntity("Se crea el perfil correctamente.", HttpStatus.CREATED);
    }
}
