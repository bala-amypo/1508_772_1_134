package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;
import java.util.List;

public interface DailySymptomLogService {

    DailySymptomLog createLog(DailySymptomLog log);

    List<DailySymptomLog> getAllLogs();

    DailySymptomLog getLogById(Long id);

    DailySymptomLog updateLog(Long id, DailySymptomLog log);

    void deleteLog(Long id);
}
