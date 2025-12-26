package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import java.util.List;

public interface RecoveryCurveService {

    RecoveryCurveProfile createProfile(RecoveryCurveProfile profile);

    List<RecoveryCurveProfile> getAllProfiles();
}
