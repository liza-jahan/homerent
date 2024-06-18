package com.example.homerent.model.request.home;

import com.example.homerent.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Table(name = "home_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeInfoUpdateRequest  {
    @NotNull(message = "Username is required")
    private String location;
    //  @NotNull(message = "Location is required")
    private int houseNumber;
    @NotNull(message = "Phone number is required")
    private String phoneNumber;

}
