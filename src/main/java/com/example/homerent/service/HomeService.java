package com.example.homerent.service;

import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;

import java.util.UUID;


public interface HomeService {
    UUID saveHome(RegistrationRequest request);
    UUID updateHomeInfo(Long id, HomeInfoUpdateRequest updatedUser);
}
