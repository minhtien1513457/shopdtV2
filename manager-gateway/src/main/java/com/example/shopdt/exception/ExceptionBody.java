package com.example.shopdt.exception;

import lombok.Getter;

@Getter
public
class ExceptionBody {
    private final long timestamp;
    private final String message;


    private ExceptionBody(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }


    public static ExceptionBody of(long timestamp, String message) {
        return new ExceptionBody(timestamp, message);
    }
}
