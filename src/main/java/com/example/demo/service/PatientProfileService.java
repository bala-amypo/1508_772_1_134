package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {

    PatientProfile createProfile(PatientProfile profile);

    List<PatientProfile> getAllProfiles();

    PatientProfile getProfileById(Long id);

    PatientProfile updateProfile(Long id, PatientProfile profile);

    void deleteProfile(Long id);
}
