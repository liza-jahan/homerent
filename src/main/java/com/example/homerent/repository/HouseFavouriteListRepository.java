package com.example.homerent.repository;

import com.example.homerent.entity.HouseFavouriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface HouseFavouriteListRepository extends JpaRepository<HouseFavouriteList, UUID> {

    Optional<HouseFavouriteList> findByIdAndHomeDetailsId(UUID userId, UUID homeDetailsId);

}
