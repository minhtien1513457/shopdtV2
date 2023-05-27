package com.example.shopdt.exception;

public class InterruptAcquireLockException extends RuntimeException {
    public InterruptAcquireLockException(String message) {
        super(message);
    }

    public InterruptAcquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
