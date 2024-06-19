package com.example.homerent.service;

import com.example.homerent.entity.HomeDetails;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;

import java.util.Optional;
import java.util.UUID;


public interface HomeService {
    UUID saveHome(RegistrationRequest request);
    Optional<HomeDetails> updateHomeDetails(UUID id, HomeInfoUpdateRequest updatedUser);
}
