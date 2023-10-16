package com.example.webwork.exceptions;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException(String message) {
        super(message);
    }
}
