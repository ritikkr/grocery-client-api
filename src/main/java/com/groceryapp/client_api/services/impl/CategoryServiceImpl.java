package com.groceryapp.client_api.services.impl;

import com.groceryapp.client_api.exception.CategoryAlreadyExistException;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.Product;
import com.groceryapp.client_api.repository.CategoryRepository;
import com.groceryapp.client_api.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) throws CategoryAlreadyExistException {
        log.info("Cat:{}", categoryRepository.findByName(category.getName()));
        Optional<Category> category1 = categoryRepository.findByName(category.getName());
        if(category1.isPresent()){
            throw new CategoryAlreadyExistException("Category already exist with name "+category.getName());
        }

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

    @Override
    public List<Product> getAllProductsByCategoryId(Long categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("No Category Found with id: "+categoryId));
        return category.getProducts();
    }
}
