package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import java.util.List;

public interface RecoveryCurveProfileService {

    RecoveryCurveProfile createProfile(RecoveryCurveProfile profile);

    List<RecoveryCurveProfile> getAllProfiles();

    RecoveryCurveProfile getProfileById(Long id);

    List<RecoveryCurveProfile> getProfilesByMetricName(String metricName);

    RecoveryCurveProfile updateProfile(Long id, RecoveryCurveProfile profile);

    void deleteProfile(Long id);
}
