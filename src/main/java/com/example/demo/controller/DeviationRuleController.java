package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DeviationRuleController {

    @Autowired
    private DeviationRuleService deviationRuleService;

    @PostMapping
    public ResponseEntity<DeviationRule> createRule(@RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<DeviationRule>> getAllRules() {
        return ResponseEntity.ok(deviationRuleService.getAllRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviationRule> getRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(deviationRuleService.getRuleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> updateRule(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.updateRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        deviationRuleService.deleteRule(id);
        return ResponseEntity.ok("Deleted");
    }
}
