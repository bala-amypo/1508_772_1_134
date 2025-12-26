package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {

    PatientProfile createPatient(PatientProfile patientProfile);

    List<PatientProfile> getAllPatients();

    PatientProfile getPatientById(Long id);

    PatientProfile updatePatient(Long id, PatientProfile patientProfile);

    void deletePatient(Long id);
}
