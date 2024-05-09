package com.example.homerent.exception;

public class TimeExistException extends BaseException{
    public TimeExistException(String message, Throwable ex, String errorCode) {
        super(message, ex, errorCode);
    }

    public TimeExistException(String message, String errorCode) {
        super(message, errorCode);
    }
}
