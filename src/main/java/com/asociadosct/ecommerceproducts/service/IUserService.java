package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.User;
import java.util.List;

public interface IUserService {

	List<User> getAll();
	void create(User user);
}