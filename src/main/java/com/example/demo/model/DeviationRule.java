package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "deviation_rules")
@Data
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surgeryType;

    @Column(nullable = false)
    private String symptomParameter; 
    // pain / mobility / fatigue

    @Column(nullable = false)
    private Integer thresholdDeviation;

    private Boolean active = true;
}
