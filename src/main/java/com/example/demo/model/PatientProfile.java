package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient_profile")
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private Integer age;

    private String gender;

    private String diagnosis;

    private LocalDate surgeryDate;

    private String recoveryPhase;

    public PatientProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getRecoveryPhase() {
        return recoveryPhase;
    }

    public void setRecoveryPhase(String recoveryPhase) {
        this.recoveryPhase = recoveryPhase;
    }
}
