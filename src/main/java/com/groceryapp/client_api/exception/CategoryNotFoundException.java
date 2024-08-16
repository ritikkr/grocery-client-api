package com.groceryapp.client_api.exception;

public class CategoryNotFoundException extends Exception{

    public CategoryNotFoundException(String message){
        super(message);
    }
}
