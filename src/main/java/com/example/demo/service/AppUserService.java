package com.example.demo.service;

import com.example.demo.model.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createUser(AppUser user);

    List<AppUser> getAllUsers();

    AppUser getUserById(Long id);

    AppUser updateUser(Long id, AppUser user);

    void deleteUser(Long id);
}
