package com.example.homerent.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

    private String errorCode;
    private String message;

}

