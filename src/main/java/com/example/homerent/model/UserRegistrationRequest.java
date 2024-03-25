package com.example.homerent.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


import static com.example.homerent.utils.StringUtils.PASSWORD_REGEX;

@Getter
@Setter
public class UserRegistrationRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    @Pattern(regexp = PASSWORD_REGEX)
    private String password;
}
