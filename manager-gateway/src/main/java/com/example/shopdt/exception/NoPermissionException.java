package com.example.shopdt.exception;

public class NoPermissionException extends HandledException {
    public NoPermissionException() {
        super("You do not have permission.", 403);
    }

    public NoPermissionException(String message) {
        super(message, 403);
    }

    public NoPermissionException(String message, int code) {
        super(message, code);
    }
}
