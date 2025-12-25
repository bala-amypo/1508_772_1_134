package com.recoverytracker.controller;

import com.recoverytracker.model.AppUser;
import com.recoverytracker.service.AppUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "App User Controller", description = "APIs for User Management")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    // ================= CREATE USER =================
    @Operation(summary = "Create new user (Doctor / Patient / Admin)")
    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
        AppUser savedUser = appUserService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // ================= LOGIN USER =================
    @Operation(summary = "Login user using email and password")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestParam String email,
            @RequestParam String password) {

        boolean isValid = appUserService.login(email, password);

        if (isValid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }

    // ================= GET ALL USERS =================
    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }

    // ================= GET USER BY ID =================
    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    // ================= UPDATE USER =================
    @Operation(summary = "Update user details")
    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(
            @PathVariable Long id,
            @RequestBody AppUser user) {

        return ResponseEntity.ok(appUserService.updateUser(id, user));
    }

    // ================= DELETE USER =================
    @Operation(summary = "Delete user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
