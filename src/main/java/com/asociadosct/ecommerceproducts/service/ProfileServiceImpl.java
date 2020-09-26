package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Profile;
import com.asociadosct.ecommerceproducts.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    /**
     * Inyeccion de dependencias
     */
    @Autowired
    protected ProfileRepository profileRepository;

    @Override
    @Transactional
    public Profile save(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profile> findAll() {
        return this.profileRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProfile(Profile profile) {
        this.profileRepository.delete(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profile> getProfile(Integer id) {
        return this.profileRepository.findById(id);
    }
}