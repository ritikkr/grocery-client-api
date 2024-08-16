package com.groceryapp.client_api.services;

import com.groceryapp.client_api.exception.CategoryAlreadyExistException;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.model.Category;

public interface CategoryService {

    public Category createCategory(Category category) throws CategoryAlreadyExistException;
    public Category getCategoryById(Long id) throws CategoryNotFoundException;
    public Category deleteCategoryById(Long id) throws CategoryNotFoundException;
}
