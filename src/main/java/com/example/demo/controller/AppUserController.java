package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        return ResponseEntity.ok(appUserService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(
            @PathVariable Long id,
            @RequestBody AppUser user) {
        return ResponseEntity.ok(appUserService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
