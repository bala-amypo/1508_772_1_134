package com.example.demo.service;

import com.example.demo.model.ClinicalAlert;

import java.util.List;
import java.util.Optional;

public interface ClinicalAlertService {

    ClinicalAlert saveAlert(ClinicalAlert alert);

    List<ClinicalAlert> getAllAlerts();

    Optional<ClinicalAlert> getAlertById(Long id);

    void deleteAlert(Long id);

    List<ClinicalAlert> getAlertsByUserId(Long userId);

    List<ClinicalAlert> getAlertsByType(String alertType);
}
