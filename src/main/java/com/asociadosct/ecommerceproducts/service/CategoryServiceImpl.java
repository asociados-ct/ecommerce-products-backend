package com.asociadosct.ecommerceproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * Inyeccion de dependencias
     */
    @Autowired
    protected CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> getCategory(Integer id) {
        return this.categoryRepository.findById(id);
    }
}
