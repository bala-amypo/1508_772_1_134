package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

  
    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) {
        AppUser savedUser = service.register(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    
    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody AppUser user) {
        AppUser loggedUser =
                service.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loggedUser);
    }
}
