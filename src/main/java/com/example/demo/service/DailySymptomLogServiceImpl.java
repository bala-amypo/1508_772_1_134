package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.time.LocalDate;
import java.util.List;

public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepo;
    private final PatientProfileRepository patientRepo;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertService alertService;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository logRepo,
            PatientProfileRepository patientRepo,
            RecoveryCurveService recoveryCurveService,
            DeviationRuleService deviationRuleService,
            ClinicalAlertService alertService) {

        this.logRepo = logRepo;
        this.patientRepo = patientRepo;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.alertService = alertService;
    }

    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        patientRepo.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future date");
        }

        logRepo.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate())
                .ifPresent(l -> {
                    throw new IllegalArgumentException("Duplicate daily log");
                });

        return logRepo.save(log);
    }

    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {
        DailySymptomLog existing = logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        updated.setId(existing.getId());
        updated.setPatientId(existing.getPatientId());

        return logRepo.save(updated);
    }

    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        return logRepo.findByPatientId(patientId);
    }
}
