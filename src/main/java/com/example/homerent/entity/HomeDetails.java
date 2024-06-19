package com.example.homerent.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;


@Table(name = "home_details")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class HomeDetails extends BaseEntity {

        @NotNull(message = "Username is required")
        private String location;
     //@NotNull(message = "Location is required")
        private int houseNumber;
        @NotNull(message = "Phone number is required")
        private String phoneNumber;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private boolean verified;
//base
}
