package com.groceryapp.client_api.exception;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(String message){
        super(message);
    }
}
