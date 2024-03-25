package com.example.homerent.exception;

public class IdentifierExistException  extends BaseException{
    public IdentifierExistException(String message, Throwable ex, String errorCode) {
        super(message, ex, errorCode);
    }

    public IdentifierExistException(String message, String errorCode) {
        super(message, errorCode);
    }
}
