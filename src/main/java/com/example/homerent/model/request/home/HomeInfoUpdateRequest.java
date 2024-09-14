package com.example.homerent.model.request.home;


import com.example.homerent.utils.StringUtils;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HomeInfoUpdateRequest  {
    @NotNull(message = "location is required")
    private String location;
    @Positive(message = "should be positive")
    @Max(value = 100000,message = "Value shoe be lass than 100000")
    private int houseNumber;
    @Pattern(regexp = StringUtils.phoneRegex)
    private String phoneNumber;

}
