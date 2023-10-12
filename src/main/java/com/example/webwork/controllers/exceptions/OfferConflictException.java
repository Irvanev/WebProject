package com.example.webwork.controllers.exceptions;

public class OfferConflictException extends RuntimeException {
    public OfferConflictException(String message) {
        super(message);
    }
}
