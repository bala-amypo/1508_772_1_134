package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.stereotype.Service;

@Service
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    @Override
    public RecoveryCurveProfile getRecoveryCurve(Long id) {
        return RecoveryCurveProfile.builder()
                .id(id)
                .metricName("Recovery")
                .expectedValue(75.0)
                .build();
    }
}
