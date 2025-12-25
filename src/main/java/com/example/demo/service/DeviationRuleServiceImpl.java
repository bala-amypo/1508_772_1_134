package com.example.demo.service;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    @Autowired
    private DeviationRuleRepository deviationRuleRepository;

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        return deviationRuleRepository.save(rule);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return deviationRuleRepository.findAll();
    }

    @Override
    public DeviationRule getRuleById(Long id) {
        return deviationRuleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<DeviationRule> getRulesByMetricName(String metricName) {
        return deviationRuleRepository.findByMetricName(metricName);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        DeviationRule existingRule = deviationRuleRepository.findById(id).orElseThrow();
        existingRule.setMetricName(rule.getMetricName());
        existingRule.setMinValue(rule.getMinValue());
        existingRule.setMaxValue(rule.getMaxValue());
        existingRule.setConditionType(rule.getConditionType());
        existingRule.setAlertMessage(rule.getAlertMessage());
        return deviationRuleRepository.save(existingRule);
    }

    @Override
    public void deleteRule(Long id) {
        deviationRuleRepository.deleteById(id);
    }
}
