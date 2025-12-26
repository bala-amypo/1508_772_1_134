package com.example.demo.service;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository patientProfileRepository;

    public PatientProfileServiceImpl(PatientProfileRepository patientProfileRepository) {
        this.patientProfileRepository = patientProfileRepository;
    }

    @Override
    public PatientProfile createPatient(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return patientProfileRepository.findAll();
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return patientProfileRepository.findById(id).orElseThrow();
    }

    @Override
    public PatientProfile updatePatient(Long id, PatientProfile patientProfile) {
        PatientProfile existing = patientProfileRepository.findById(id).orElseThrow();
        existing.setPatientName(patientProfile.getPatientName());
        existing.setAge(patientProfile.getAge());
        existing.setGender(patientProfile.getGender());
        existing.setDiagnosis(patientProfile.getDiagnosis());
        return patientProfileRepository.save(existing);
    }

    @Override
    public void deletePatient(Long id) {
        patientProfileRepository.deleteById(id);
    }
}
