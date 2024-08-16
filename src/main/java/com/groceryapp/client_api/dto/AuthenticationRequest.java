package com.groceryapp.client_api.dto;


import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;

    // getters and setters
}
