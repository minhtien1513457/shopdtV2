package com.example.shopdt.exception;

public class LockTimeoutException extends RuntimeException {
    public LockTimeoutException(String message) {
        super(message);
    }
}
