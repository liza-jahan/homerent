package com.example.homerent.service.impl;

import com.example.homerent.entity.Role;
import com.example.homerent.entity.UserEntity;
import com.example.homerent.enums.Month;
import com.example.homerent.enums.UserType;
import com.example.homerent.exception.IdentifierExistException;
import com.example.homerent.exception.NotFoundException;
import com.example.homerent.model.request.ResetPasswordRequest;
import com.example.homerent.model.request.UserRegistrationRequest;
import com.example.homerent.repository.UserRepository;
import com.example.homerent.service.JwtService;
import com.example.homerent.service.RoleService;
import com.example.homerent.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private  final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

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

    @Override
    public UUID sendResetPasswordToken(String email) {
      Optional<String> user = userRepository.findUserByEmail(email);
        if(user.isEmpty())
        {
            throw new NotFoundException("Email not found", "01-U01-002");
        }
        //create password reset token
        String passwordResetToken = jwtService.createPasswordResetToken(user);


        //send email with password reset token
        emailService.sendEmail(email,"Reset password homerent",
                "Your password reset token is http://localhost:8080/api/v1/users/resetPassword?token="+passwordResetToken);

        return UUID.randomUUID();
    }

    @Override
    @Transactional
    public String resetPassword(ResetPasswordRequest request) {

        //verify token
        String email = jwtService.verifyPasswordResetToken(request.getToken());

        //update password
        String encodedPassword = passwordEncoder.encode(request.getNewPassword());
        userRepository.updatePassword(email,encodedPassword);
        return email;
    }




    private boolean isUserExist(UserRegistrationRequest request) {
        return userRepository.findUserByEmail(request.getEmail()).isPresent();
    }

    public static void main(String[] args) {
        System.out.println(Month.JANUARY.getShortName().toLowerCase());
    }
}
