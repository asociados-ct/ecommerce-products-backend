package com.asociadosct.ecommerceproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.service.IProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	IProductService productService;

	@GetMapping(path = "/")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/")
	public ResponseEntity<String> create(@RequestBody Product product) {
		productService.create(product);
	    return new ResponseEntity("Se crea el perfil correctamente.", HttpStatus.CREATED);
	}
}