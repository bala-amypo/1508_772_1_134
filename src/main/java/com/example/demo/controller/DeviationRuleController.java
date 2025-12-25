package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Deviation Rules")
public class DeviationRuleController {

    @Autowired
    private DeviationRuleService deviationRuleService;

    @Operation(summary = "Create deviation rule")
    @PostMapping
    public ResponseEntity<DeviationRule> createRule(@RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.createRule(rule));
    }

    @Operation(summary = "Get all deviation rules")
    @GetMapping
    public ResponseEntity<List<DeviationRule>> getAllRules() {
        return ResponseEntity.ok(deviationRuleService.getAllRules());
    }

    @Operation(summary = "Get deviation rule by ID")
    @GetMapping("/{id}")
    public ResponseEntity<DeviationRule> getRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(deviationRuleService.getRuleById(id));
    }

    @Operation(summary = "Get rules by metric name")
    @GetMapping("/metric/{metricName}")
    public ResponseEntity<List<DeviationRule>> getRulesByMetric(@PathVariable String metricName) {
        return ResponseEntity.ok(deviationRuleService.getRulesByMetricName(metricName));
    }

    @Operation(summary = "Update deviation rule")
    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> updateRule(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviation
