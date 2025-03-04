package com.accioshoppingbackend.Shopping_Backend.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
