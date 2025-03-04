package com.accioshoppingbackend.Shopping_Backend.exception;

public class WrongCredentialsException extends RuntimeException {

    public WrongCredentialsException(String message) {
        super(message);
    }
}
