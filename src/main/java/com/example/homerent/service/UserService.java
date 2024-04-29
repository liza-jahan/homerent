package com.example.homerent.service;

import com.example.homerent.model.request.UserRegistrationRequest;

import java.util.UUID;

public interface UserService {
    UUID saveUser(UserRegistrationRequest request);
    UUID createForgetPasswordLink(String email);


}
