package com.example.homerent.service;

import com.example.homerent.model.AuthenticationResponse;
import com.example.homerent.model.request.AuthenticationRequest;
import com.example.homerent.model.request.RefreshTokenRequest;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);

    AuthenticationResponse refreshToken(RefreshTokenRequest request);

    void logout(String username);
}
