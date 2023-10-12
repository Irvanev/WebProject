package com.example.webwork.controllers.exceptions;

public class BrandNotFoundException extends RuntimeException{
    public BrandNotFoundException(Long id) {
        super("Could not find brand " + id);
    }
}
