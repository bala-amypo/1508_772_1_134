package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deviation_rules")
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String symptomName;

    @Column(nullable = false)
    private Integer threshold;

    @Column(nullable = false)
    private String conditionType;

    @ManyToOne
    @JoinColumn(name = "recovery_curve_id")
    private RecoveryCurveProfile recoveryCurveProfile;

    public DeviationRule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public RecoveryCurveProfile getRecoveryCurveProfile() {
        return recoveryCurveProfile;
    }

    public void setRecoveryCurveProfile(RecoveryCurveProfile recoveryCurveProfile) {
        this.recoveryCurveProfile = recoveryCurveProfile;
    }
}
