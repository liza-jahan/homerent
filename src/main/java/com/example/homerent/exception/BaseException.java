package com.example.homerent.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private String errorCode;
    private String message;

    public BaseException(String message, Throwable ex, String errorCode){
        super(message, ex);
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
