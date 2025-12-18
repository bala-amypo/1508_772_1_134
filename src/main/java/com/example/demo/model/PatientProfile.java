package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_profiles")
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private int age;
    private String gender;
    private String diagnosis;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    // No-arg constructor
    public PatientProfile() {
    }

    // Parameterized constructor
    public PatientProfile(String patientName, int age, String gender,
                          String diagnosis, AppUser user) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.user = user;
    }

    // Getters and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
