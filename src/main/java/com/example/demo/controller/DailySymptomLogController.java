package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    @PostMapping
    public DailySymptomLog create(@RequestBody DailySymptomLog log) {
        return service.createLog(log);
    }

    @GetMapping
    public List<DailySymptomLog> getAll() {
        return service.getAllLogs();
    }

    @GetMapping("/{id}")
    public DailySymptomLog getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @PutMapping("/{id}")
    public DailySymptomLog update(@PathVariable Long id, @RequestBody DailySymptomLog log) {
        return service.updateLog(id, log);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLog(id);
    }
}
