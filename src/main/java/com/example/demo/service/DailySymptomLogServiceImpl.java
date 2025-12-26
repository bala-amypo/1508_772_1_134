package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private DailySymptomLogRepository dailySymptomLogRepository;
    private PatientProfileRepository patientProfileRepository;

    // REQUIRED BY TESTS
    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository dailySymptomLogRepository,
            PatientProfileRepository patientProfileRepository
    ) {
        this.dailySymptomLogRepository = dailySymptomLogRepository;
        this.patientProfileRepository = patientProfileRepository;
    }

    // REQUIRED BY SPRING / TESTS
    public DailySymptomLogServiceImpl() {
    }

    @Override
    public DailySymptomLog createLog(DailySymptomLog log) {
        return dailySymptomLogRepository.save(log);
    }

    @Override
    public List<DailySymptomLog> getAllLogs() {
        return dailySymptomLogRepository.findAll();
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return dailySymptomLogRepository.findById(id).orElse(null);
    }

    @Override
    public List<DailySymptomLog> getLogsByDate(LocalDate date) {
        return dailySymptomLogRepository.findByLogDate(date);
    }

    // 🔴 THIS METHOD WAS MISSING → NOW FIXED
    @Override
    public List<DailySymptomLog> getLogsBySeverity(String severity) {
        return dailySymptomLogRepository.findBySeverity(severity);
    }
}
