package com.accioshoppingbackend.Shopping_Backend.exception;

public class UserNotAllowed extends RuntimeException {
    public UserNotAllowed(String message) {
        super(message);
    }
}
