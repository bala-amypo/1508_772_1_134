package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveProfileController {

    @Autowired
    private RecoveryCurveService recoveryCurveService;

    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> createProfile(
            @RequestBody RecoveryCurveProfile profile) {
        return ResponseEntity.ok(recoveryCurveService.createProfile(profile));
    }

    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAllProfiles() {
        return ResponseEntity.ok(recoveryCurveService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecoveryCurveProfile> getProfileById(
            @PathVariable Long id) {
        return ResponseEntity.ok(recoveryCurveService.getProfileById(id));
    }

    @GetMapping("/metric/{metricName}")
    public ResponseEntity<List<RecoveryCurveProfile>> getProfilesByMetric(
            @PathVariable String metricName) {
        return ResponseEntity.ok(
                recoveryCurveService.getProfilesByMetricName(metricName)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecoveryCurveProfile> updateProfile(
            @PathVariable Long id,
            @RequestBody RecoveryCurveProfile profile) {
        return ResponseEntity.ok(
                recoveryCurveService.updateProfile(id, profile)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        recoveryCurveService.deleteProfile(id);
        return ResponseEntity.ok("Recovery curve profile deleted successfully");
    }
}
