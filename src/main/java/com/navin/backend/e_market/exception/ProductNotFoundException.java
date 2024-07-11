package com.navin.backend.e_market.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message){
       super(message);
    }
}
