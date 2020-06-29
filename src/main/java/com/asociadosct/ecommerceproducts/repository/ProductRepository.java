package com.asociadosct.ecommerceproducts.repository;

import com.asociadosct.ecommerceproducts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}