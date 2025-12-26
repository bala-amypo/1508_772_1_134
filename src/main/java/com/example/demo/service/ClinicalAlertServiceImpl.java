package com.example.demo.service;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository clinicalAlertRepository;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository clinicalAlertRepository) {
        this.clinicalAlertRepository = clinicalAlertRepository;
    }

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        return clinicalAlertRepository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return clinicalAlertRepository.findAll();
    }

    @Override
    public ClinicalAlert getAlertById(Long id) {
        return clinicalAlertRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ClinicalAlert> getAlertsBySeverity(String severity) {
        return clinicalAlertRepository.findBySeverity(severity);
    }

    @Override
    public List<ClinicalAlert> getUnresolvedAlerts() {
        return clinicalAlertRepository.findByResolved(false);
    }

    @Override
    public ClinicalAlert resolveAlert(Long id) {
        ClinicalAlert alert = clinicalAlertRepository.findById(id).orElseThrow();
        alert.setResolved(true);
        return clinicalAlertRepository.save(alert);
    }
}
