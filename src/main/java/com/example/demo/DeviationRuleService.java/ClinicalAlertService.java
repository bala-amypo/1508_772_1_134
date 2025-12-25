package com.example.demo.service;

import com.example.demo.model.ClinicalAlert;

import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlert createAlert(ClinicalAlert alert);

    List<ClinicalAlert> getAllAlerts();

    ClinicalAlert getAlertById(Long id);

    List<ClinicalAlert> getAlertsBySeverity(String severity);

    List<ClinicalAlert> getUnresolvedAlerts();

    ClinicalAlert resolveAlert(Long id);
}
