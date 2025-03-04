package com.accioshoppingbackend.Shopping_Backend.exception;

public class InvalidProductException extends RuntimeException {

    public InvalidProductException(String message) {
        super(message);
    }
}
