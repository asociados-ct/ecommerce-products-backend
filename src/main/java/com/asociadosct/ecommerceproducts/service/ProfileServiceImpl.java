package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Profile;
import com.asociadosct.ecommerceproducts.repository.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileServiceImpl implements  IProfileService {

    @Autowired
    IProfileRepository profileRepository;

    public List<Profile> getAll(){
        return profileRepository.findAll();
    }

    public void create(Profile profile){
        profileRepository.save(profile);
    }
}
