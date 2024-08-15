package com.groceryapp.client_api.services;


import com.groceryapp.client_api.exception.OrderNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Order;
import com.groceryapp.client_api.model.OrderStatus;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order) throws UserNotFoundException;
    Order getOrderById(Long orderId);
    List<Order> getOrdersByUser(Long userId);
    void cancelOrder(Long orderId) throws OrderNotFoundException;
    void confirmOrder(Long orderId);
    void updateOrderStatus(Long orderId, OrderStatus newStatus) throws OrderNotFoundException;
}