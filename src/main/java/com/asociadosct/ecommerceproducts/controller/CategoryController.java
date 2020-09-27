package com.asociadosct.ecommerceproducts.controller;

import com.asociadosct.ecommerceproducts.entity.Category;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;
import com.asociadosct.ecommerceproducts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = {"https://ecommerce-sct.netlify.app","http://localhost:4200"} )
@CrossOrigin(origins =  "${var.origins.url}")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private static final String NOT_FOUND_MESSAGE = "No se encuentra la categoría con el ID :: ";

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Category category = categoryService.getCategory(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + id));
        return ResponseEntity.ok().body(category);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> createCategory(@RequestBody @Valid Category category) {
        categoryService.save(category);
        return new ResponseEntity<>("Se crea la categoria correctamente.", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    // @Valid se encarga de revisar si las validaciones de la clase se cumplen
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Integer categoryId,
            @Valid @RequestBody Category categoryParam) throws ResourceNotFoundException {
        Category category = categoryService.getCategory(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + categoryId));
        category.setName(categoryParam.getName());

        final Category updateCategory = categoryService.save(category);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Category category = categoryService.getCategory(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + id));

        this.categoryService.deleteCategory(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}