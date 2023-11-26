package com.example.webwork.exceptions;

import java.util.UUID;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException(String message) {
        super(message);
    }
}
