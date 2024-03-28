package com.example.homerent.controller;


import com.example.homerent.model.APIResponse;
import com.example.homerent.model.AuthenticationResponse;
import com.example.homerent.model.CreationResponse;
import com.example.homerent.model.request.AuthenticationRequest;
import com.example.homerent.model.request.RefreshTokenRequest;
import com.example.homerent.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<APIResponse<AuthenticationResponse>> login(@RequestBody @Valid AuthenticationRequest request) {

        final AuthenticationResponse login = authenticationService.login(request);

        APIResponse<AuthenticationResponse> responseDTO = APIResponse
                .<AuthenticationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(login)
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @PostMapping("/refresh")
    public ResponseEntity<APIResponse<AuthenticationResponse>> refresh(@RequestBody @Valid RefreshTokenRequest request){

        final AuthenticationResponse refreshToken = authenticationService.refreshToken(request);
        APIResponse<AuthenticationResponse> responseDTO = APIResponse
                .<AuthenticationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(refreshToken)
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @PostMapping("/logout")
//    @PreAuthorize("isAuthenticated()")
//    public ResponseObject logout(Principal principal){
//
//        authenticationService.logout(principal.getName());
//
//        return ResponseObject.builder()
//                .status(ResponseObject.ResponseStatus.SUCCESSFUL)
//                .message("User logged out successfully")
//                .build();
//    }
}
