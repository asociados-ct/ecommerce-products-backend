package com.asociadosct.ecommerceproducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asociadosct.ecommerceproducts.entity.User;
import com.asociadosct.ecommerceproducts.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void create(User user) {
		userRepository.save(user);
	}

	
}