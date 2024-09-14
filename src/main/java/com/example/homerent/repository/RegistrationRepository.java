package com.example.homerent.repository;

import com.example.homerent.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<UserEntity,Long> {
}
