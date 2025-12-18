package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.service.RecoveryCurveProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl
        implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveProfileServiceImpl(
            RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecoveryCurveProfile create(RecoveryCurveProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<RecoveryCurveProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public RecoveryCurveProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public RecoveryCurveProfile update(Long id,
                                       RecoveryCurveProfile profile) {
        RecoveryCurveProfile existing = getById(id);
        existing.setParameterName(profile.getParameterName());
        existing.setExpectedMinValue(profile.getExpectedMinValue());
        existing.setExpectedMaxValue(profile.getExpectedMaxValue());
        existing.setRecoveryPhase(profile.getRecoveryPhase());
        existing.setPatientProfile(profile.getPatientProfile());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
