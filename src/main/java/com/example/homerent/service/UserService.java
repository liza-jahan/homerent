package com.example.homerent.service;

import com.example.homerent.model.UserRegistrationRequest;

import java.util.UUID;

public interface UserService {
    UUID saveUser(UserRegistrationRequest request);
}
