package com.example.demo.service.impl;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public DailySymptomLog createLog(DailySymptomLog log) {
        return repository.save(log);
    }

    @Override
    public List<DailySymptomLog> getAllLogs() {
        return repository.findAll();
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DailySymptomLog updateLog(Long id, DailySymptomLog log) {
        DailySymptomLog existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setLogDate(log.getLogDate());
        existing.setSymptomName(log.getSymptomName());
        existing.setSeverity(log.getSeverity());
        existing.setNotes(log.getNotes());
        existing.setPatientProfile(log.getPatientProfile());
        return repository.save(existing);
    }

    @Override
    public void deleteLog(Long id) {
        repository.deleteById(id);
    }
}
