package com.groceryapp.client_api.dto;
import com.groceryapp.client_api.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private Address shippingAddress;
    private List<OrderItemRequest> orderItems;
    private String paymentMethod;

}