package com.example.homerent.repository;

import com.example.homerent.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<UserEntity,Long> {
}
