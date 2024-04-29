package com.example.homerent.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ForgotPasswordResponse {
    private String email;

}
