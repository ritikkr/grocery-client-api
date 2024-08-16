package com.groceryapp.client_api.services.impl;

import com.groceryapp.client_api.exception.CategoryAlreadyExistException;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.repository.CategoryRepository;
import com.groceryapp.client_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) throws CategoryAlreadyExistException {
        Category category1 = categoryRepository.findByName(category.getName()).orElseThrow(() -> new CategoryAlreadyExistException("Category already exist with name"+category.getName()));


        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("No Category Found with id: "+id));
    }

    @Override
    public Category deleteCategoryById(Long id) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("No Category Found with id: "+id));
        categoryRepository.deleteById(id);
        return category;
    }
}
