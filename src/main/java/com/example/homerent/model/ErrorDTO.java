package com.example.homerent.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private String field;
    private String errorMessage;
    private String errorCode;

    public ErrorDTO(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }
}
