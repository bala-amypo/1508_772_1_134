package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class DailySymptomLogController {

    @Autowired
    private DailySymptomLogService dailySymptomLogService;

    @PostMapping
    public ResponseEntity<DailySymptomLog> createLog(@RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.createLog(log));
    }

    @GetMapping
    public ResponseEntity<List<DailySymptomLog>> getAllLogs() {
        return ResponseEntity.ok(dailySymptomLogService.getAllLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailySymptomLog> getLogById(@PathVariable Long id) {
        return ResponseEntity.ok(dailySymptomLogService.getLogById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<DailySymptomLog>> getLogsByDate(@PathVariable String date) {
        return ResponseEntity.ok(
                dailySymptomLogService.getLogsByDate(LocalDate.parse(date))
        );
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<DailySymptomLog>> getLogsBySeverity(@PathVariable String severity) {
        return ResponseEntity.ok(dailySymptomLogService.getLogsBySeverity(severity));
    }
}
