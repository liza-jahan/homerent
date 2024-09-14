package com.example.homerent.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(String message, Throwable ex, String errorCode) {
        super(message, ex, errorCode);
    }

    public NotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}