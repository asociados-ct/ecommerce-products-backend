package com.asociadosct.ecommerceproducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void create(Category category) {
		categoryRepository.save(category);

	}
}
