package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Profile;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    /**
     *
     * @param profile
     * @return
     */
    Profile save(Profile profile);

    /**
     *
     * @return
     */
    List<Profile> findAll();

    /**
     *
     * @param profile
     * @throws ResourceNotFoundException
     */
    void deleteProfile(Profile profile) throws ResourceNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Optional<Profile> getProfile(Integer id);
}