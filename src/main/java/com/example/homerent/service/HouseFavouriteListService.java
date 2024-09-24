package com.example.homerent.service;

import com.example.homerent.entity.HouseFavouriteList;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HouseFavouriteListService {
    UUID addFavorite(UUID userId, UUID homeDetailsId);
    void removeFavorite(UUID userId, UUID homeDetailsId);

    List<HouseFavouriteList> getAllFavouriteList();
}
