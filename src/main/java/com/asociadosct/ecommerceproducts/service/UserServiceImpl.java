package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.User;
import com.asociadosct.ecommerceproducts.entity.UserProfile;
import com.asociadosct.ecommerceproducts.repository.ProfileRepository;
import com.asociadosct.ecommerceproducts.repository.UserProfileRepository;
import com.asociadosct.ecommerceproducts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    /**
     * Inyeccion de dependencias
     */
    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;


    @Override
    public User save(User user) {
        User createdUser = userRepository.save(user);

        user.getProfiles().forEach((UserProfile prof) -> {

            prof.setUser(createdUser);
            prof.setProfile(profileRepository.getOne(prof.getProfile().getProfileId()));
            prof.setStatus(true);
            userProfileRepository.save(prof);
        });
        return createdUser;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(Integer id) {
        return this.userRepository.findById(id);
    }


}