package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    @Autowired
    private DailySymptomLogRepository dailySymptomLogRepository;

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
        return dailySymptomLogRepository.findById(id).orElseThrow();
    }

    @Override
    public List<DailySymptomLog> getLogsByDate(LocalDate date) {
        return dailySymptomLogRepository.findByLogDate(date);
    }

    @Override
    public List<DailySymptomLog> getLogsBySeverity(String severity) {
        return dailySymptomLogRepository.findBySeverity(severity);
    }
}
