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

    
    @PostMapping
    public ClinicalAlert createAlert(@RequestBody ClinicalAlert alert) {
        return clinicalAlertService.saveAlert(alert);
    }

  
    @GetMapping
    public List<ClinicalAlert> getAllAlerts() {
        return clinicalAlertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlert> getAlertById(@PathVariable Long id) {
        return clinicalAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        clinicalAlertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }

   
    @GetMapping("/user/{userId}")
    public List<ClinicalAlert> getAlertsByUserId(@PathVariable Long userId) {
        return clinicalAlertService.getAlertsByUserId(userId);
    }

 
    @GetMapping("/type/{alertType}")
    public List<ClinicalAlert> getAlertsByType(@PathVariable String alertType) {
        return clinicalAlertService.getAlertsByType(alertType);
    }
}
