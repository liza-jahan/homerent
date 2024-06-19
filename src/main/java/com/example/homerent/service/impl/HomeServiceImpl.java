package com.example.homerent.service.impl;


import com.example.homerent.entity.HomeDetails;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;
import com.example.homerent.repository.HomeRepository;
import com.example.homerent.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;
    @Override
    public UUID saveHome(RegistrationRequest request) {
//       HomeDetails homeDetails= new HomeDetails();
//       BeanUtils.copyProperties(request,homeDetails);
        try {
            HomeDetails homeDetails = HomeDetails.builder()
                    .location(request.getLocation())
                    .houseNumber(request.getHouseNumber())
                    .phoneNumber(request.getPhoneNumber())
                    .credentialsNonExpired(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .verified(true)
                    .build();
            homeRepository.save(homeDetails);

            return homeDetails.getId();
        }
        catch (Exception e){
            return  null;
        }

    }

    @Override

    public Optional<HomeDetails> updateHomeDetails(UUID id, HomeInfoUpdateRequest homeInfoUpdateRequest) {
        return homeRepository.findById(id).map(existingHomeDetails -> {
            HomeDetails homeDetails = HomeDetails.builder()
                    .location(homeInfoUpdateRequest.getLocation())
                    .houseNumber(homeInfoUpdateRequest.getHouseNumber() != 0 ? homeInfoUpdateRequest.getHouseNumber() : existingHomeDetails.getHouseNumber())
                    .phoneNumber(homeInfoUpdateRequest.getPhoneNumber())
                    .accountNonExpired(existingHomeDetails.isAccountNonExpired())
                    .accountNonLocked(existingHomeDetails.isAccountNonLocked())
                    .credentialsNonExpired(existingHomeDetails.isCredentialsNonExpired())
                    .enabled(existingHomeDetails.isEnabled())
                    .verified(existingHomeDetails.isVerified())
                    .build();

            homeDetails.setId(existingHomeDetails.getId()); // Ensure the ID remains the same

            return homeRepository.save(homeDetails);
        });
        }
}
//builder pattern ,Object mapper
