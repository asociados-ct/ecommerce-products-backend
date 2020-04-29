package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.entity.User;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

	/**
	 *
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 *
	 * @return
	 */
	List<User> findAll();

	/**
	 *
	 * @param user
	 * @throws ResourceNotFoundException
	 */
	void deleteUser(User user) throws ResourceNotFoundException;

	/**
	 *
	 * @param id
	 * @return
	 */
	Optional<User> getUser(Integer id);
}