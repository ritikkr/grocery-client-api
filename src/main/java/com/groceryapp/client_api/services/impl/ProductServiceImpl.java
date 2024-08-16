package com.groceryapp.client_api.services.impl;

import com.groceryapp.client_api.dto.ProductRequest;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.exception.ProductNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.Product;
import com.groceryapp.client_api.repository.CategoryRepository;
import com.groceryapp.client_api.repository.ProductRepository;
import com.groceryapp.client_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No Product found with id: "+id));
    }

    @Override
    public Product addProduct(ProductRequest productRequest) throws CategoryNotFoundException {

        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("No Category found with id"+productRequest.getCategoryId()));


        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setCategory(category);



        // updating the product list for the  category
        category.getProducts().add(product);

        return productRepository.save(product);
    }

    @Override
    public Product deleteProductById(Long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No Product Found with id:"+id));
        productRepository.deleteById(id);
        return product;
    }
}
