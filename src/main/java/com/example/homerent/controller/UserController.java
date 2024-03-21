package com.example.homerent.controller;

import com.example.homerent.model.UserRegistrationRequest;
import com.example.homerent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String registerUser(@Valid @RequestBody UserRegistrationRequest request){
        UUID userId = userService.saveUser(request);
        return "User created successfully. Generated Id is  ".concat(userId.toString());
    }
}
