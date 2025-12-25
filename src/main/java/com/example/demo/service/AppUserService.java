package com.recoverytracker.service;

import com.recoverytracker.model.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createUser(AppUser user);

    boolean login(String email, String password);

    List<AppUser> getAllUsers();

    AppUser getUserById(Long id);

    AppUser updateUser(Long id, AppUser user);

    void deleteUser(Long id);
}
