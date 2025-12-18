package com.example.demo.service.impl;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repository;

    public PatientProfileServiceImpl(PatientProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientProfile createProfile(PatientProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<PatientProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public PatientProfile getProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient profile not found"));
    }

    @Override
    public PatientProfile updateProfile(Long id, PatientProfile profile) {

        PatientProfile existing = getProfileById(id);

        existing.setPatientName(profile.getPatientName());
        existing.setAge(profile.getAge());
        existing.setGender(profile.getGender());
        existing.setDiagnosis(profile.getDiagnosis());
        existing.setUser(profile.getUser());

        return repository.save(existing);
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
