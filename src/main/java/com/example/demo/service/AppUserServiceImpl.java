package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
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
