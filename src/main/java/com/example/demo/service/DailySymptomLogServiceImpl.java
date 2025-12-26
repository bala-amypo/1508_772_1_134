package com.example.demo.service;

import com.example.demo.repository.DailySymptomLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    @Autowired
    private DailySymptomLogRepository dailySymptomLogRepository;

    // REQUIRED BY TESTS
    public DailySymptomLogServiceImpl() {
    }

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repo) {
        this.dailySymptomLogRepository = repo;
    }
}
