package com.groceryapp.client_api.services;

import com.groceryapp.client_api.exception.CategoryAlreadyExistException;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    public Category createCategory(Category category) throws CategoryAlreadyExistException;
    public Category getCategoryById(Long id) throws CategoryNotFoundException;
    public Category deleteCategoryById(Long id) throws CategoryNotFoundException;

    List<Product> getAllProductsByCategoryId(Long categoryId) throws CategoryNotFoundException;
}
