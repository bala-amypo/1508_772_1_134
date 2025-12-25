package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface AuthService {

    AppUser login(String email, String password);

    AppUser register(AppUser user);
}
