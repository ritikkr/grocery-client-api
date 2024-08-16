package com.groceryapp.client_api.exception;

public class CategoryAlreadyExistException extends Exception{

    public CategoryAlreadyExistException(String message){
        super(message);
    }
}
