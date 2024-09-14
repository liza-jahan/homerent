package com.example.homerent.model.request.home;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    UUID id;
    @NotNull(message = "Username is required")
    private String location;
 //  @NotNull(message = "Location is required")
    private int houseNumber;
    @NotNull(message = "Phone number is required")
    private String phoneNumber;

}
