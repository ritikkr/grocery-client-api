package com.groceryapp.client_api.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
}
