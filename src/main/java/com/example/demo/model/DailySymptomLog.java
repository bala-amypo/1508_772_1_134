package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_symptom_logs")
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate logDate;
    private String symptomName;
    private String severity;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_profile_id")
    private PatientProfile patientProfile;

    public DailySymptomLog() {
    }

    public DailySymptomLog(LocalDate logDate,
                           String symptomName,
                           String severity,
                           String notes,
                           PatientProfile patientProfile) {
        this.logDate = logDate;
        this.symptomName = symptomName;
        this.severity = severity;
        this.notes = notes;
        this.patientProfile = patientProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PatientProfile getPatientProfile() {
        return patientProfile;
    }

    public void setPatientProfile(PatientProfile patientProfile) {
        this.patientProfile = patientProfile;
    }
}
