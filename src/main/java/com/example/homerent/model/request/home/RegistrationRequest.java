package com.example.homerent.model.request.home;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @NotNull(message = "Username is required")
    private String location;
    @NotNull(message = "Location is required")
    private String houseNumber;
    @NotNull(message = "Phone number is required")
    private String phoneNumber;

}
