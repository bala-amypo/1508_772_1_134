package com.example.demo.repository;

import com.example.demo.model.ClinicalAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicalAlertRepository extends JpaRepository<ClinicalAlert, Long> {

    // Find all alerts for a specific user
    List<ClinicalAlert> findByUserId(Long userId);

    // Optional: Find alerts by type
    List<ClinicalAlert> findByAlertType(String alertType);
}
