package com.example.demo.controller;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Clinical Alerts")
public class ClinicalAlertController {

    @Autowired
    private ClinicalAlertService clinicalAlertService;

    @Operation(summary = "Create a clinical alert")
    @PostMapping
    public ResponseEntity<ClinicalAlert> createAlert(@RequestBody ClinicalAlert alert) {
        return ResponseEntity.ok(clinicalAlertService.createAlert(alert));
    }

    @Operation(summary = "Get all clinical alerts")
    @GetMapping
    public ResponseEntity<List<ClinicalAlert>> getAllAlerts() {
        return ResponseEntity.ok(clinicalAlertService.getAllAlerts());
    }

    @Operation(summary = "Get alert by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlert> getAlertById(@PathVariable Long id) {
        return ResponseEntity.ok(clinicalAlertService.getAlertById(id));
    }

    @Operation(summary = "Get alerts by severity")
    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<ClinicalAlert>> getAlertsBySeverity(@PathVariable String severity) {
        return ResponseEntity.ok(clinicalAlertService.getAlertsBySeverity(severity));
    }

    @Operation(summary = "Get unresolved alerts")
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClinicalAlert>> getUnresolvedAlerts() {
        return ResponseEntity.ok(clinicalAlertService.getUnresolvedAlerts());
    }

    @Operation(summary = "Resolve a clinical alert")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlert> resolveAlert(@PathVariable Long id) {
        return ResponseEntity.ok(clinicalAlertService.resolveAlert(id));
    }
}
