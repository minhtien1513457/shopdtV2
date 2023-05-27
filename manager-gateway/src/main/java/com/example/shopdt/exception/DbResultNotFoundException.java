package com.example.shopdt.exception;

public class DbResultNotFoundException extends RuntimeException {
    public DbResultNotFoundException(String message) {
        super(message);
    }
}
