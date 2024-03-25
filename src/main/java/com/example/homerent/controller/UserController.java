package com.example.homerent.controller;

import com.example.homerent.model.APIResponse;
import com.example.homerent.model.CreationResponse;
import com.example.homerent.model.UserRegistrationRequest;
import com.example.homerent.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<APIResponse<CreationResponse>> registerUser(@Valid @RequestBody UserRegistrationRequest request){
        UUID userId = userService.saveUser(request);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(userId))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
