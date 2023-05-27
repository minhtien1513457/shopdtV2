package com.example.shopdt.exception;

public class NotFoundException extends HandledException {

    public NotFoundException() {
        super("Not found", 404);
    }

    public NotFoundException(String message) {
        super(message, 404);
    }

    public NotFoundException(Throwable throwable) {
        super("Not found", 404, throwable);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, 404, throwable);
    }
}
