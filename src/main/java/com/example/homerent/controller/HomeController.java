package com.example.homerent.controller;


import com.example.homerent.model.APIResponse;
import com.example.homerent.model.CreationResponse;
import com.example.homerent.model.request.UserRegistrationRequest;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.service.HomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("homes")//
@RequiredArgsConstructor
//@Slf4j
public class HomeController {
private final HomeService homeService;
@PostMapping //("register")
    public ResponseEntity<APIResponse<CreationResponse>> homeRegister(@RequestBody @Valid RegistrationRequest registrationRequest){
        UUID homeId = homeService.saveHome(registrationRequest);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(homeId))
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
