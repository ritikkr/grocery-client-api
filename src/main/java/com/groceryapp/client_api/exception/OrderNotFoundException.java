package com.groceryapp.client_api.exception;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(String message){
        super(message);
    }
}
