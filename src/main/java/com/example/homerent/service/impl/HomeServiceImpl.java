package com.example.homerent.service.impl;

import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final RegistrationRequest registrationRequest;
    @Override
    public UUID saveHome(RegistrationRequest request) {
        return null;
    }
}
