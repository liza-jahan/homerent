package com.example.homerent.service;

import com.example.homerent.model.request.UserRegistrationRequest;
import com.example.homerent.model.request.home.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface HomeService {
    UUID saveHome(RegistrationRequest request);
}
