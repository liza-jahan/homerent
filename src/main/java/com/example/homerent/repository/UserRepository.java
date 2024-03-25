package com.example.homerent.repository;

import com.example.homerent.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("select user.email from UserEntity user where user.email=:email")
    Optional<String> findUserByEmail(String email);
}
