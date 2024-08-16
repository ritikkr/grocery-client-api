package com.groceryapp.client_api.controller;

import com.groceryapp.client_api.dto.ProductRequest;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.exception.ProductNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Product;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.services.ProductService;
import com.groceryapp.client_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/product")
    public  ResponseEntity<Product> createProduct(@RequestBody ProductRequest product) throws CategoryNotFoundException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK );
    }

    @DeleteMapping("/product/{id}")
    public  ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }


}
