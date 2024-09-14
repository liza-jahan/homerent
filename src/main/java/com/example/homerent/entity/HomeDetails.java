package com.example.homerent.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;


@Table(name = "home_details")
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class HomeDetails extends BaseEntity {

        private String location;
        private int houseNumber;
        private String phoneNumber;
//    @ManyToOne
//    private UserEntity user;
//base
}
