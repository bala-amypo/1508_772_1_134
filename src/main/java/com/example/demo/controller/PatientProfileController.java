package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    @Autowired
    private PatientProfileService patientProfileService;

    @PostMapping
    public ResponseEntity<PatientProfile> createPatient(@RequestBody PatientProfile patientProfile) {
        return ResponseEntity.ok(patientProfileService.createPatient(patientProfile));
    }

    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(patientProfileService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientProfileService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientProfile> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientProfile patientProfile) {
        return ResponseEntity.ok(patientProfileService.updatePatient(id, patientProfile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientProfileService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
