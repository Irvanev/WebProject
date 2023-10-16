package com.example.webwork.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Long id) {
        super("Could not find role " + id);
    }
}
