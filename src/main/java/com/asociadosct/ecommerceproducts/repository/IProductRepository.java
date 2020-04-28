package com.asociadosct.ecommerceproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asociadosct.ecommerceproducts.entity.Product;;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
