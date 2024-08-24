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

import java.util.List;

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

    @GetMapping("/product")
    public  ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/productByName/{name}")
    public  ResponseEntity<List<Product>> getAllProductByNameLike(@PathVariable("name")String name){
        return new ResponseEntity<>(productService.getAllProductByNameLike(name), HttpStatus.OK);
    }

    @GetMapping("/product/random")
    public  ResponseEntity<List<Product>> getProductsRandomly(){
        return new ResponseEntity<>(productService.getProductsRandomly(), HttpStatus.OK);
    }


}
