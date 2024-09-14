package com.example.homerent.service.impl;


import com.example.homerent.entity.Role;
import com.example.homerent.enums.RoleName;
import com.example.homerent.enums.UserType;
import com.example.homerent.repository.RoleRepository;
import com.example.homerent.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByUserType(UserType userType) {
        RoleName roleName = switch (userType) {
            case CUSTOMER -> RoleName.ROLE_CUSTOMER;
            case ADMIN -> RoleName.ROLE_ADMIN;
        };

        return roleRepository.findByName(roleName).orElseThrow(() -> new
                EntityNotFoundException("Role not found"));
    }
}
