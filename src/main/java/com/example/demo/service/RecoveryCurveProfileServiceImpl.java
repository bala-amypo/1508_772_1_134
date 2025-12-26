package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl
        implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveProfileServiceImpl(RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecoveryCurveProfile createProfile(RecoveryCurveProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<RecoveryCurveProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public RecoveryCurveProfile updateProfile(Long id, RecoveryCurveProfile profile) {
        profile.setId(id);
        return repository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
