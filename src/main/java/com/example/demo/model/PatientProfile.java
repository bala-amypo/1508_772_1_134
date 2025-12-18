package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "patient_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "patientId"),
        @UniqueConstraint(columnNames = "email")
    }
)
@Data
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String patientId;

    @Column(nullable = false)
    private String fullName;

    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String surgeryType;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}
