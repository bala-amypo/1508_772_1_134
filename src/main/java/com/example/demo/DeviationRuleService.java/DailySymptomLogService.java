package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;

import java.time.LocalDate;
import java.util.List;

public interface DailySymptomLogService {

    DailySymptomLog createLog(DailySymptomLog log);

    List<DailySymptomLog> getAllLogs();

    DailySymptomLog getLogById(Long id);

    List<DailySymptomLog> getLogsByDate(LocalDate date);

    List<DailySymptomLog> getLogsBySeverity(String severity);
}
