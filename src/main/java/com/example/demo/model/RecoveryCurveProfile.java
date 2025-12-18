package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recovery_curve_profiles")
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parameterName;
    private Double expectedMinValue;
    private Double expectedMaxValue;
    private String recoveryPhase;

    @ManyToOne
    @JoinColumn(name = "patient_profile_id")
    private PatientProfile patientProfile;

    public RecoveryCurveProfile() {
    }

    public RecoveryCurveProfile(String parameterName,
                                Double expectedMinValue,
                                Double expectedMaxValue,
                                String recoveryPhase,
                                PatientProfile patientProfile) {
        this.parameterName = parameterName;
        this.expectedMinValue = expectedMinValue;
        this.expectedMaxValue = expectedMaxValue;
        this.recoveryPhase = recoveryPhase;
        this.patientProfile = patientProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Double getExpectedMinValue() {
        return expectedMinValue;
    }

    public void setExpectedMinValue(Double expectedMinValue) {
        this.expectedMinValue = expectedMinValue;
    }

    public Double getExpectedMaxValue() {
        return expectedMaxValue;
    }

    public void setExpectedMaxValue(Double expectedMaxValue) {
        this.expectedMaxValue = expectedMaxValue;
    }

    public String getRecoveryPhase() {
        return recoveryPhase;
    }

    public void setRecoveryPhase(String recoveryPhase) {
        this.recoveryPhase = recoveryPhase;
    }

    public PatientProfile getPatientProfile() {
        return patientProfile;
    }

    public void setPatientProfile(PatientProfile patientProfile) {
        this.patientProfile = patientProfile;
    }
}
