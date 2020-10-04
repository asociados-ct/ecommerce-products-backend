package com.asociadosct.ecommerceproducts.controller;

import com.asociadosct.ecommerceproducts.entity.Product;
import com.asociadosct.ecommerceproducts.exception.ResourceNotFoundException;
import com.asociadosct.ecommerceproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final String NOT_FOUND_PRODUCT_MESSAGE = "No se encuentra el producto con el ID :: ";
    private static final String PRODUCT_SUCCESSFUL = "Se crea el producto correctamente.";

    @Autowired
    ProductService productService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PRODUCT_MESSAGE + id));
        return ResponseEntity.ok().body(product);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(PRODUCT_SUCCESSFUL, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    //@Valid se encarga de revisar si las validaciones de la clase se cumplen
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @Valid @RequestBody Product productParam)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PRODUCT_MESSAGE + productId));
        product.setName(productParam.getName());
        product.setCategory(productParam.getCategory());
        product.setDescription(productParam.getDescription());
        product.setWeigth(productParam.getWeigth());
        product.setPrice(productParam.getPrice());
        product.setPhoto1(productParam.getPhoto1());
        product.setPhoto2(productParam.getPhoto2());
        product.setPhoto3(productParam.getPhoto3());

        final Product updateProduct = productService.save(product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PRODUCT_MESSAGE + id));

        this.productService.deleteProduct(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}