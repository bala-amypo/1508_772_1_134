package com.example.demo.repository;

import com.example.demo.model.ClinicalAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalAlertRepository
        extends JpaRepository<ClinicalAlert, Long> {
}
