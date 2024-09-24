package com.example.homerent.controller;

import com.example.homerent.entity.HouseFavouriteList;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.response.APIResponse;
import com.example.homerent.model.response.CreationResponse;
import com.example.homerent.model.response.DeleteCreationResponse;
import com.example.homerent.service.HouseFavouriteListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/favouriteHome")
@RequiredArgsConstructor
public class FavouriteHomeListController {
    private final HouseFavouriteListService houseFavouriteListService;

    @PostMapping //("register")
    public ResponseEntity<APIResponse<CreationResponse>> addFavouriteList(@RequestParam UUID userId, @RequestParam UUID homeDetailsId){
        UUID favoriteHomeId = houseFavouriteListService.addFavorite(userId,homeDetailsId);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(favoriteHomeId))
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping ("/userId/{userId}/homeDetailsId/{homeDetailsId}")
    public ResponseEntity<APIResponse<DeleteCreationResponse>> removeHomeDetails(@PathVariable UUID homeDetailsId, @PathVariable UUID userId){
        houseFavouriteListService.removeFavorite(userId,homeDetailsId);
        DeleteCreationResponse deleteCreationResponse=new DeleteCreationResponse(userId,homeDetailsId);
        APIResponse<DeleteCreationResponse> responseDTO = APIResponse
                .<DeleteCreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(deleteCreationResponse)
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
