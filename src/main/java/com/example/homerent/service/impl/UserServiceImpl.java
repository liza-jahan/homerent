package com.example.homerent.service.impl;

import com.example.homerent.entity.Role;
import com.example.homerent.entity.UserEntity;
import com.example.homerent.enums.UserType;
import com.example.homerent.exception.IdentifierExistException;
import com.example.homerent.model.request.UserRegistrationRequest;
import com.example.homerent.repository.UserRepository;
import com.example.homerent.service.RoleService;
import com.example.homerent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UUID saveUser(UserRegistrationRequest userRegistrationRequest) {

        if (isUserExist(userRegistrationRequest))
            throw new IdentifierExistException("Email Already Registered", "01-U01-001");

        Role role = roleService.getRoleByUserType(UserType.CUSTOMER);

        UserEntity userEntity = UserEntity.builder()
                .firstName(userRegistrationRequest.getFirstName())
                .lastName(userRegistrationRequest.getLastName())
                .username(userRegistrationRequest.getEmail())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .phoneNumber(userRegistrationRequest.getPhoneNumber())
                .roles(Collections.singleton(role))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        userEntity = userRepository.save(userEntity);
        return userEntity.getId();
    }

    private boolean isUserExist(UserRegistrationRequest request) {
        return userRepository.findUserByEmail(request.getEmail()).isPresent();
    }
}
