package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public DeviationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        DeviationRule existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setRuleName(rule.getRuleName());
        existing.setSymptomName(rule.getSymptomName());
        existing.setThreshold(rule.getThreshold());
        existing.setConditionType(rule.getConditionType());
        existing.setRecoveryCurveProfile(rule.getRecoveryCurveProfile());
        return repository.save(existing);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
