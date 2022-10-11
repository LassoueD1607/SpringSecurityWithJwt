package com.lassoued.springsecuritywithjwt.service;

import com.lassoued.springsecuritywithjwt.domain.AppUser;
import com.lassoued.springsecuritywithjwt.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers(); //you want to use pagination here in real life
}
