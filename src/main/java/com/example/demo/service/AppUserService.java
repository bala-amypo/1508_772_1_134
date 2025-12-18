package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface AppUserService {

    AppUser register(AppUser user);

    AppUser login(String email, String password);
}
