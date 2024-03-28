package com.example.homerent.controller;

import com.example.homerent.model.APIResponse;
import com.example.homerent.model.CreationResponse;
import com.example.homerent.model.request.UserRegistrationRequest;
import com.example.homerent.service.UserService;
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
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<APIResponse<CreationResponse>> registerUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
        log.info("Received user registration request: {}", userRegistrationRequest);
        UUID userId = userService.saveUser(userRegistrationRequest);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(userId))
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("forgotPassword")
    public ResponseEntity<APIResponse<String>> initiatePasswordResetLink(){

        APIResponse<String> responseDTO = APIResponse
                .<String>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results("Password reset request has been send to the email")
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @GetMapping
//    @PreAuthorize("hasAuthority('users:read')")
//    public ResponseObject<Page<UserResponse>> getAllUsers(@PageableDefault(
//            sort = "id", direction = Sort.Direction.DESC
//    ) Pageable pageable){
//
//        return ResponseObject.<Page<UserResponse>>builder()
//                .status(ResponseObject.ResponseStatus.SUCCESSFUL)
//                .data(userService.getAllUsers(pageable))
//                .build();
//    }
}
