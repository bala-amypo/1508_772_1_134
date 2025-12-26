package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;

import java.util.List;
import java.util.Optional;

public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repo;

    public DeviationRuleServiceImpl(DeviationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        if (rule.getThreshold() == null || rule.getThreshold() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }
        return repo.save(rule);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        DeviationRule existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
        rule.setId(existing.getId());
        return repo.save(rule);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repo.findAll();
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {
        return repo.findByRuleCode(ruleCode);
    }
}
