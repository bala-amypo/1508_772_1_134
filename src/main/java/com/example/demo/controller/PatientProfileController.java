package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    // ✅ Create Patient Profile
    @PostMapping
    public ResponseEntity<PatientProfile> createProfile(
            @RequestBody PatientProfile profile) {

        PatientProfile savedProfile = service.createProfile(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    // ✅ Get All Patient Profiles
    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAllProfiles() {
        return ResponseEntity.ok(service.getAllProfiles());
    }

    // ✅ Get Patient Profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProfileById(id));
    }

    // ✅ Update Patient Profile
    @PutMapping("/{id}")
    public ResponseEntity<PatientProfile> updateProfile(
            @PathVariable Long id,
            @RequestBody PatientProfile profile) {

        return ResponseEntity.ok(service.updateProfile(id, profile));
    }

    // ✅ Delete Patient Profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
