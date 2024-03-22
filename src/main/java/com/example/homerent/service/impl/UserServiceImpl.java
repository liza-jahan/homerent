package com.example.homerent.service.impl;

import com.example.homerent.entity.UserEntity;
import com.example.homerent.model.UserRegistrationRequest;
import com.example.homerent.repository.UserRepository;
import com.example.homerent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UUID saveUser(UserRegistrationRequest request) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(request, userEntity);
        final Date date = new Date();
        userEntity.setCreatedTime(date);
        userEntity.setLastUpdateTime(date);
        userEntity.setAccountActive(true);
        userEntity = userRepository.save(userEntity);
        return userEntity.getId();
    }
}
