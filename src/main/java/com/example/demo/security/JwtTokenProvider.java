package com.example.demo.security;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public JwtTokenProvider(String secret, long validityInMs) {}

    public String generateToken(AppUser user) {
        return "dummy-jwt-token";
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}
