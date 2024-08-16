package com.groceryapp.client_api.services;


import com.groceryapp.client_api.dto.ProductRequest;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.exception.ProductNotFoundException;
import com.groceryapp.client_api.model.Product;

public interface ProductService {

    public Product getProductById(Long id) throws ProductNotFoundException;
    public Product addProduct(ProductRequest productRequest) throws CategoryNotFoundException;
    public Product deleteProductById(Long id) throws ProductNotFoundException;
}
