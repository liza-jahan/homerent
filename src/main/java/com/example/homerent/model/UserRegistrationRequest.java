package com.example.homerent.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static com.example.homerent.utils.StringUtils.PASSWORD_REGEX;

@Getter
@Setter
public class UserRegistrationRequest {
    @NotEmpty
    private String firstName;
    @NotBlank
    private String middleName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private String phoneNumber;
    @Pattern(regexp = PASSWORD_REGEX)
    private String password;
}
