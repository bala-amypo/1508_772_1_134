package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveProfileServiceImpl(RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecoveryCurveProfile createProfile(RecoveryCurveProfile profile) {
        return repository.save(profile);
    }

    @Override
    public RecoveryCurveProfile getProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecoveryCurveProfile not found"));
    }

    @Override
    public List<RecoveryCurveProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public List<RecoveryCurveProfile> getProfilesByMetricName(String metricName) {
        return repository.findByMetricName(metricName);
    }

    @Override
    public RecoveryCurveProfile updateProfile(Long id, RecoveryCurveProfile profile) {
        RecoveryCurveProfile existing = getProfileById(id);

        existing.setMetricName(profile.getMetricName());
        existing.setExpectedValue(profile.getExpectedValue());
        existing.setTimePoint(profile.getTimePoint());

        return repository.save(existing);
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
