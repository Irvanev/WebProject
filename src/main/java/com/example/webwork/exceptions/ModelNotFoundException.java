package com.example.webwork.exceptions;

import java.util.UUID;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String id) {
        super("Could not find model " + id);
    }
}
