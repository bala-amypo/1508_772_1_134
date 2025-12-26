package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser updateUser(Long id, AppUser user) {

        AppUser existingUser = appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ FIXED: correct setter
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());

        return appUserRepository.save(existingUser);
    }
}
