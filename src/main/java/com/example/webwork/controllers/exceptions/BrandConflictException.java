package com.example.webwork.controllers.exceptions;

public class BrandConflictException extends RuntimeException {
    public BrandConflictException(String message) {
        super(message);
    }
}
