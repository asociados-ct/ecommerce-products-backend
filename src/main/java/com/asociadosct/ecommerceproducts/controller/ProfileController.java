package com.asociadosct.ecommerceproducts.controller;

import com.asociadosct.ecommerceproducts.entity.Profile;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;
import com.asociadosct.ecommerceproducts.service.ProfileService;
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
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private static final String NOT_FOUND_PROFILE_MESSAGE = "No se encuentra el perfil con el ID :: ";

    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Profile profile = profileService.getProfile(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PROFILE_MESSAGE + id));
        return ResponseEntity.ok().body(profile);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Profile>> getProfiles() {
        return new ResponseEntity<>(profileService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> createProfile(@Valid @RequestBody Profile profile) {
        profileService.save(profile);
        return new ResponseEntity<>("Se crea el perfil correctamente.", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    //@Valid se encarga de revisar si las validaciones de la clase se cumplen
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Integer profileId,
                                                 @Valid @RequestBody Profile profileParam)
            throws ResourceNotFoundException {
        Profile profile = profileService.getProfile(profileId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PROFILE_MESSAGE + profileId));
        profile.setName(profileParam.getName());

        // toca revisar actualización de tabla intermedia

        final Profile updateProfile = profileService.save(profile);
        return ResponseEntity.ok(updateProfile);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Profile profile = profileService.getProfile(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PROFILE_MESSAGE + id));

        this.profileService.deleteProfile(profile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}