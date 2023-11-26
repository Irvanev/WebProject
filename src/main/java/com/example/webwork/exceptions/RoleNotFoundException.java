package com.example.webwork.exceptions;

import java.util.UUID;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String id) {
        super("Could not find role " + id);
    }
}
