package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl implements RecoveryCurveProfileService {

    @Autowired
    private RecoveryCurveProfileRepository recoveryCurveProfileRepository;

    @Override
    public RecoveryCurveProfile createProfile(RecoveryCurveProfile profile) {
        return recoveryCurveProfileRepository.save(profile);
    }

    @Override
    public List<RecoveryCurveProfile> getAllProfiles() {
        return recoveryCurveProfileRepository.findAll();
    }

    @Override
    public RecoveryCurveProfile getProfileById(Long id) {
        return recoveryCurveProfileRepository.findById(id).orElseThrow();
    }

    @Override
    public List<RecoveryCurveProfile> getProfilesByMetricName(String metricName) {
        return recoveryCurveProfileRepository.findByMetricName(metricName);
    }

    @Override
    public RecoveryCurveProfile updateProfile(Long id, RecoveryCurveProfile profile) {
        RecoveryCurveProfile existing = recoveryCurveProfileRepository.findById(id).orElseThrow();
        existing.setMetricName(profile.getMetricName());
        existing.setExpectedValue(profile.getExpectedValue());
        existing.setLowerThreshold(profile.getLowerThreshold());
        existing.setUpperThreshold(profile.getUpperThreshold());
        existing.setRecordedDate(profile.getRecordedDate());
        return recoveryCurveProfileRepository.save(existing);
    }

    @Override
    public void deleteProfile(Long id) {
        recoveryCurveProfileRepository.deleteById(id);
    }
}
