package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.User;
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

    @Override
    @Transactional
    public User save(User user) {
        return this.userRepository.save(user);
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