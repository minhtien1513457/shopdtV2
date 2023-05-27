package com.example.shopdt.exception;

public class BadRequestException extends HandledException {
    public BadRequestException() {
        super("Bad Request.", 400);
    }

    public BadRequestException(String message) {
        super(message, 400);
    }

    public BadRequestException(String message, int code) {
        super(message, code);
    }
}
