package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(AppUserRepository repo,
                           PasswordEncoder encoder,
                           AuthenticationManager authManager,
                           JwtTokenProvider jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        AppUser user = AppUser.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .role(UserRole.CLINICIAN)
                .build();

        AppUser saved = repo.save(user);
        return new AuthResponse(jwt.generateToken(saved), saved.getEmail());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        return new AuthResponse(jwt.generateToken(user), user.getEmail());
    }
}
