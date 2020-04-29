package com.asociadosct.ecommerceproducts.service;

import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Inyeccion de dependencias
     */
    @Autowired
    protected ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProduct(Integer id) {
        return this.productRepository.findById(id);
    }
}