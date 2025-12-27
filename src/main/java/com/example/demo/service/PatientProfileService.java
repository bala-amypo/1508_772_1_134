package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public interface PatientProfileService {
    PatientProfile createPatient(PatientProfile profile);
    PatientProfile getPatientById(Long id);
    List<PatientProfile> getAllPatients();
    PatientProfile updatePatientStatus(Long id, boolean active);
    Optional<PatientProfile> findByPatientId(String patientId);
}
