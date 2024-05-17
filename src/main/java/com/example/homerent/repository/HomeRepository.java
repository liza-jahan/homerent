package com.example.homerent.repository;

import com.example.homerent.entity.HomeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomeDetails,Long> {
}
