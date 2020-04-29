package com.asociadosct.ecommerceproducts.service;

import java.util.List;
import java.util.Optional;

import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;

public interface CategoryService {

    /**
     *
     * @param category
     * @return
     */
    Category save(Category category);

    /**
     *
     * @return
     */
    List<Category> findAll();

    /**
     *
     * @param category
     * @throws ResourceNotFoundException
     */
    void deleteCategory(Category category) throws ResourceNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Optional<Category> getCategory(Integer id);
}