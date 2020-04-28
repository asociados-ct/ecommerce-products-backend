package com.asociadosct.ecommerceproducts.service;

import java.util.List;
import com.asociadosct.ecommerceproducts.entity.Category;

public interface ICategoryService {

    List<Category> getAll();
    void create(Category category);
}