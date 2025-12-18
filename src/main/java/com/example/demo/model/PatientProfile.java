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

    // 🔹 Link to AppUser
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    // 🔹 Constructors
    public PatientPr
