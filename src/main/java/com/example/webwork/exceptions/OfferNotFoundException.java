package com.example.webwork.exceptions;

import java.util.UUID;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(String id) {
        super("Could not find offer " + id);
    }
}
