package com.example.webwork.controllers.exceptions;

public class ModelConflictException extends RuntimeException {
    public ModelConflictException(String message) {
        super(message);
    }
}
