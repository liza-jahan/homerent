package com.example.homerent.service.impl;


import com.example.homerent.entity.HomeDetails;
import com.example.homerent.model.request.home.RegistrationRequest;
import com.example.homerent.model.request.home.HomeInfoUpdateRequest;
import com.example.homerent.repository.HomeRepository;
import com.example.homerent.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public UUID updateHomeInfo(Long id, HomeInfoUpdateRequest updatedHomeInfo) {
        HomeDetails homeDetails= homeRepository.findById(id).orElseThrow(() -> new RuntimeException("Home Information not found"));


        homeDetails.setLocation(updatedHomeInfo.getLocation());
        homeDetails.setHouseNumber(updatedHomeInfo.getHouseNumber());
        homeDetails.setPhoneNumber(updatedHomeInfo.getPhoneNumber());

        homeRepository.save(homeDetails);
        return homeDetails.getId();


    }
}
//builder pattern ,Object mapper