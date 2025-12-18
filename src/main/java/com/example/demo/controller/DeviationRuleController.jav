package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DeviationRule create(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<DeviationRule> getAll() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public DeviationRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @PutMapping("/{id}")
    public DeviationRule update(@PathVariable Long id, @RequestBody DeviationRule rule) {
        return service.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRule(id);
    }
}
