package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Product;
import java.util.List;

public interface IProductService {
	
	List<Product> getAll();
	void create(Product product);
}