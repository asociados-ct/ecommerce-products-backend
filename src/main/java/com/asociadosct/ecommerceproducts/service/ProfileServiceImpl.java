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
    protected ProfileRepository ProfileRepository;

    @Override
    @Transactional
    public Profile save(Profile profile) {
        return this.ProfileRepository.save(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profile> findAll() {
        return this.ProfileRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProfile(Profile profile) {
        this.ProfileRepository.delete(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profile> getProfile(Integer id) {
        return this.ProfileRepository.findById(id);
    }
}
