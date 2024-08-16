package com.groceryapp.client_api.repository;

import com.groceryapp.client_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



//    List<Order> findByUserId(Long userId);
}
