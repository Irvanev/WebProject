package com.example.webwork.exceptions;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(Long id) {
        super("Could not find offer " + id);
    }
}
