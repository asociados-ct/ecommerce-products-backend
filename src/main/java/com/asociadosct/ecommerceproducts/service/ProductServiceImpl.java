package com.asociadosct.ecommerceproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.repository.IProductRepository;
import java.util.List;


@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public void create(Product product) {
		productRepository.save(product);
	}
}