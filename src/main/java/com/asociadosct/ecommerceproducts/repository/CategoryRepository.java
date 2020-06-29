package com.asociadosct.ecommerceproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asociadosct.ecommerceproducts.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}