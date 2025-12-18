package com.example.demo.controller;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinical-alerts")
public class ClinicalAlertController {

    @Autowired
    private ClinicalAlertService clinicalAlertService;

    // Create a new alert
    @PostMapping
    public ClinicalAlert createAlert(@RequestBody ClinicalAlert alert) {
        return clinicalAlertService.saveAlert(alert);
    }

    // Get all alerts
    @GetMapping
    public List<ClinicalAlert> getAllAlerts() {
        return clinicalAlertService.getAllAlerts();
    }

    // Get alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlert> getAlertById(@PathVariable Long id) {
        return clinicalAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete alert by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        clinicalAlertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }

    // Get alerts by user ID
    @GetMapping("/user/{userId}")
    public List<ClinicalAlert> getAlertsByUserId(@PathVariable Long userId) {
        return clinicalAlertService.getAlertsByUserId(userId);
    }

    // Get alerts by alert type
    @GetMapping("/type/{alertType}")
    public List<ClinicalAlert> getAlertsByType(@PathVariable String alertType) {
        return clinicalAlertService.getAlertsByType(alertType);
    }
}
