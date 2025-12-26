package com.example.demo.repository;

import com.example.demo.model.ClinicalAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalAlertRepository
        extends JpaRepository<ClinicalAlert, Long> {
}
