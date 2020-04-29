package com.asociadosct.ecommerceproducts.repository;

import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asociadosct.ecommerceproducts.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {



}
