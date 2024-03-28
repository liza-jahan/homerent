package com.example.homerent.service;


import com.example.homerent.entity.Role;
import com.example.homerent.enums.UserType;

public interface RoleService {

    Role getRoleByUserType(UserType userType);
}
