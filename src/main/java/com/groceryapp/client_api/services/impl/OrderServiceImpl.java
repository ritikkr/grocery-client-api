package com.groceryapp.client_api.services.impl;


import com.groceryapp.client_api.exception.OrderNotFoundException;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.Order;
import com.groceryapp.client_api.model.OrderStatus;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.repository.OrderRepository;
import com.groceryapp.client_api.repository.ProductRepository;
import com.groceryapp.client_api.repository.UserRepository;
import com.groceryapp.client_api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    // ... other repositories as needed

    @Override
    public Order createOrder(Order order) throws UserNotFoundException {
        User user = userRepository.findById(order.getUser().getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        order.setUser(user);

        // Calculate total amount
        calculateTotalAmount(order);

        // Check product availability
        checkProductAvailability(order);

        // Create order and order items
        Order savedOrder = orderRepository.save(order);

        // Update product stock
//        updateProductStock(order);

        // Create payment (if applicable)
        // ...

        // Send order confirmation email
        // ...

        return savedOrder;
    }


    private void calculateTotalAmount(Order order) {
        // Logic to calculate total amount based on order items
    }

    private void checkProductAvailability(Order order) {
        // Logic to check product availability based on order items
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
//        return orderRepository.findByUserId(userId);
        return new ArrayList<>();
    }


    @Override
    public void cancelOrder(Long orderId) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    @Override
    public void confirmOrder(Long orderId) {
        // Implement logic to confirm order, e.g., update stock, create delivery order
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus newStatus) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        order.setOrderStatus(newStatus);
        orderRepository.save(order);
    }
}