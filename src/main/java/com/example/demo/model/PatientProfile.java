package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient_profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED BY TESTS
    private String patientId;

    // REQUIRED BY TESTS
    private String fullName;

    // REQUIRED BY TESTS
    private String email;

    private String patientName;
    private Integer age;
    private String gender;
    private String diagnosis;
    private LocalDate surgeryDate;
    private String recoveryPhase;

    // REQUIRED BY TESTS
    private Boolean active;
}
