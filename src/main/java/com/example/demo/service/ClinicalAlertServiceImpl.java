package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    @Autowired
    private ClinicalAlertRepository repository;

    @Override
    public ClinicalAlert saveAlert(ClinicalAlert alert) {
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public Optional<ClinicalAlert> getAlertById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAlert(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClinicalAlert> getAlertsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ClinicalAlert> getAlertsByType(String alertType) {
        return repository.findByAlertType(alertType);
    }
}
