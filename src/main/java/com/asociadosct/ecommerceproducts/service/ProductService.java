package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	/**
	 *
	 * @param product
	 * @return
	 */
	Product save(Product product);

	/**
	 *
	 * @return
	 */
	List<Product> findAll();

	/**
	 *
	 * @param product
	 * @throws ResourceNotFoundException
	 */
	void deleteProduct(Product product) throws ResourceNotFoundException;

	/**
	 *
	 * @param id
	 * @return
	 */
	Optional<Product> getProduct(Integer id);
}