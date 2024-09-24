package com.example.homerent.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCreationResponse {

        private UUID userId;
        private UUID homeDetailsId;


    }

