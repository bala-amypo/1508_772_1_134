package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl
        implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repo;

    public RecoveryCurveProfileServiceImpl(
            RecoveryCurveProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public RecoveryCurveProfile createProfile(RecoveryCurveProfile profile) {
        return repo.save(profile);
    }

    @Override
    public List<RecoveryCurveProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public RecoveryCurveProfile getProfileById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<RecoveryCurveProfile> getProfilesByMetricName(String metricName) {
        return repo.findByMetricName(metricName);
    }

    @Override
    public RecoveryCurveProfile updateProfile(Long id, RecoveryCurveProfile profile) {
        profile.setId(id);
        return repo.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        repo.deleteById(id);
    }
}
