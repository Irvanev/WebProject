package com.example.webwork.exceptions;

import java.util.UUID;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(UUID id) {
        super("Could not find user " + id);
    }
}
