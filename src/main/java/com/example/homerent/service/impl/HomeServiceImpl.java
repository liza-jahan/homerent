package com.example.homerent.service.impl;


import com.example.homerent.entity.HomeDetails;
import com.example.homerent.entity.UserEntity;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;
import com.example.homerent.repository.HomeRepository;
import com.example.homerent.service.HomeService;
import com.example.homerent.service.UserService;
import com.example.homerent.utils.CurrentLogInUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;
    private  final UserService userService;
    @Override
    public UUID saveHome(RegistrationRequest request) {
//       HomeDetails homeDetails= new HomeDetails();
//       BeanUtils.copyProperties(request,homeDetails);

            HomeDetails homeDetails = HomeDetails.builder()
                    .location(request.getLocation())
                    .houseNumber(request.getHouseNumber())
                    .phoneNumber(request.getPhoneNumber())
                    .build();
            homeRepository.save(homeDetails);

            return homeDetails.getId();

    }

    @Override
    public Optional<HomeDetails> updateHomeDetails(UUID id, HomeInfoUpdateRequest homeInfoUpdateRequest) {
        // Find by id
        HomeDetails existingHomeDetails = homeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Home details not found"));

        String currentUsername = CurrentLogInUtils.getCurrentUsername();
        UserEntity currentUserDetails = userService.getUserByEmail(currentUsername);


        existingHomeDetails.setPhoneNumber(homeInfoUpdateRequest.getPhoneNumber());
        existingHomeDetails.setLocation(homeInfoUpdateRequest.getLocation());
        existingHomeDetails.setHouseNumber(homeInfoUpdateRequest.getHouseNumber());
        existingHomeDetails.setLastUpdateTime(new Date());
        existingHomeDetails.setLastUpdatedBy(currentUserDetails);


        homeRepository.save(existingHomeDetails);
        //  saveHomeDetails(currentUserDetails, currentUsername, homeInfoUpdateRequest);

        //ORM
        return Optional.of(existingHomeDetails);
    }

    @Override
    public List<HomeDetails> getAllDetails() {

        return null;
    }
//    private void saveHomeDetails(UserEntity user,String userName,  HomeInfoUpdateRequest homeInfoUpdateRequest) {
//
//        HomeDetails homeDetails = HomeDetails.builder()
//                .houseNumber(homeInfoUpdateRequest.getHouseNumber())
//                .location(homeInfoUpdateRequest.getLocation())
//                .phoneNumber(homeInfoUpdateRequest.getPhoneNumber())
//                .build();
//
//        homeRepository.save(homeDetails);
//    }
}
//builder pattern ,Object mapper
