package com.groceryapp.client_api.controller;

import com.groceryapp.client_api.dto.OrderRequest;
import com.groceryapp.client_api.exception.CategoryNotFoundException;
import com.groceryapp.client_api.exception.OrderNotFoundException;
import com.groceryapp.client_api.exception.ProductNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Category;
import com.groceryapp.client_api.model.Order;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.services.CategoryService;
import com.groceryapp.client_api.services.OrderService;
import com.groceryapp.client_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getCategoryById(@PathVariable("id") Long id) throws OrderNotFoundException {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/order")
    public  ResponseEntity<Order> createCategory(@RequestBody OrderRequest orderRequest) throws UserNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(orderService.createOrder(orderRequest), HttpStatus.OK );
    }




}
