package com.asociadosct.ecommerceproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> create(@RequestBody Category category) {
    	categoryService.create(category);
        return new ResponseEntity("Se crea la categoria correctamente.", HttpStatus.CREATED);
    }
}
