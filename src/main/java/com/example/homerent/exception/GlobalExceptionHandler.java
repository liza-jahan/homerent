package com.example.homerent.exception;


import com.example.homerent.model.APIResponse;
import com.example.homerent.model.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        List<ErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorDTO errorDTO = new ErrorDTO(error.getField(), error.getDefaultMessage());
                    errors.add(errorDTO);
                });
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    @ExceptionHandler(IdentifierExistException.class)
    public APIResponse<?> handleServiceException(IdentifierExistException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO(null, exception.getMessage(), exception.getErrorCode())));
        return serviceResponse;
    }

    @ExceptionHandler(NotFoundException.class)
    public APIResponse<?> handleNotFoundException(NotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO(null, exception.getMessage(), exception.getErrorCode())));
        return serviceResponse;
    }


}
