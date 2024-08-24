package com.groceryapp.client_api.exception;

public class TokenExpired extends Exception{

    public TokenExpired(String message){
        super(message);
    }
}
