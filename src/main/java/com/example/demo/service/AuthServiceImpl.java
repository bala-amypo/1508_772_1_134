package com.example.demo.service.impl;

import com.example.demo.model.AppUser;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AppUser login(String email, String password) {
        return AppUser.builder()
                .email(email)
                .password(password)
                .role("USER")
                .build();
    }

    @Override
    public AppUser register(AppUser user) {
        return user;
    }
}
