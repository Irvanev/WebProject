package com.example.webwork.controllers.exceptions;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException(String message) {
        super(message);
    }
}
