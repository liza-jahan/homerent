package com.example.homerent.controller;


import com.example.homerent.entity.HomeDetails;
import com.example.homerent.model.response.APIResponse;
import com.example.homerent.model.response.CreationResponse;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.service.HomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
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


    @PutMapping ("{id}")
    public ResponseEntity<APIResponse<CreationResponse>> updateHomeInfo( @RequestBody @Valid HomeInfoUpdateRequest homeInfoUpdateRequest, @PathVariable UUID id){
        Optional<HomeDetails> updateHomeDetails=homeService.updateHomeDetails(id,homeInfoUpdateRequest);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(updateHomeDetails.get().getId()))
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
