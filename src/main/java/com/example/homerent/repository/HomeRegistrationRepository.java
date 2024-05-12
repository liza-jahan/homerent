package com.example.homerent.repository;

import com.example.homerent.model.request.home.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRegistrationRepository extends JpaRepository<RegistrationRequest,Long> {
}
