package com.groceryapp.client_api.services;


import com.groceryapp.client_api.dto.OrderRequest;
import com.groceryapp.client_api.exception.OrderNotFoundException;
import com.groceryapp.client_api.exception.ProductNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Order;
import com.groceryapp.client_api.model.OrderStatus;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest order) throws UserNotFoundException, ProductNotFoundException;
    Order getOrderById(Long orderId) throws OrderNotFoundException;
    List<Order> getOrdersByUser(Long userId) throws UserNotFoundException;
    void cancelOrder(Long orderId) throws OrderNotFoundException;
    void confirmOrder(Long orderId);
    void updateOrderStatus(Long orderId, OrderStatus newStatus) throws OrderNotFoundException;
}