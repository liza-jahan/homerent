package com.example.homerent.service.impl;

import com.example.homerent.entity.HomeDetails;
import com.example.homerent.entity.HouseFavouriteList;
import com.example.homerent.entity.UserEntity;
import com.example.homerent.repository.HomeRepository;
import com.example.homerent.repository.HouseFavouriteListRepository;
import com.example.homerent.repository.UserRepository;
import com.example.homerent.service.HouseFavouriteListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@AllArgsConstructor
public class HouseFavouriteListServiceImp implements HouseFavouriteListService {
    private  final UserRepository userRepository;
    private  final HomeRepository homeRepository;
    private final HouseFavouriteListRepository houseFavouriteListRepository;
    @Override
    public UUID addFavorite(UUID userId, UUID homeDetailsId) {
      UserEntity userEntity= userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found by id"));
        HomeDetails homeDetails=homeRepository.findById(homeDetailsId).orElseThrow(() -> new RuntimeException("not found by home details id"));

        HouseFavouriteList houseFavouriteList= new HouseFavouriteList();
        houseFavouriteList.setUserEntity(userEntity);
        houseFavouriteList.setHomeDetails(homeDetails);

       houseFavouriteListRepository.save(houseFavouriteList);
       return  houseFavouriteList.getId();

    }

    @Override
    public void removeFavorite(UUID userId, UUID homeDetailsId) {
      Optional<HouseFavouriteList> houseFavouriteList =houseFavouriteListRepository.findByIdAndHomeDetailsId(userId,homeDetailsId);
        houseFavouriteList.ifPresent(houseFavouriteListRepository::delete);
    }

    @Override
    public List<HouseFavouriteList> getAllFavouriteList() {

        return houseFavouriteListRepository.findAll();
    }
}
