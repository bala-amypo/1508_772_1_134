package com.recoverytracker.service;

import com.recoverytracker.model.AppUser;
import com.recoverytracker.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public boolean login(String email, String password) {
        return appUserRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).orElseThrow();
    }

    @Override
    public AppUser updateUser(Long id, AppUser user) {
        AppUser existingUser = appUserRepository.findById(id).orElseThrow();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return appUserRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        appUserRepository.deleteById(id);
    }
}
