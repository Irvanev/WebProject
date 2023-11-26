package com.example.webwork.exceptions;

import java.util.UUID;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(String id) {
        super("Could not find user " + id);
    }
}
