package com.example.demo.service;

import com.example.demo.model.DeviationRule;
import java.util.List;

public interface DeviationRuleService {

    DeviationRule createRule(DeviationRule rule);

    List<DeviationRule> getAllRules();

    DeviationRule getRuleById(Long id);

    DeviationRule updateRule(Long id, DeviationRule rule);

    void deleteRule(Long id);
}
