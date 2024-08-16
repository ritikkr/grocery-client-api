package com.groceryapp.client_api.controller;

import com.groceryapp.client_api.exception.CategoryAlreadyExistException;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.services.CategoryService;
import com.groceryapp.client_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public  ResponseEntity<Category> createCategory(@RequestBody Category category) throws CategoryAlreadyExistException {
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.OK );
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.deleteCategoryById(id), HttpStatus.OK);
    }


}
