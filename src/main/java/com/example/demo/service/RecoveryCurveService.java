package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RecoveryCurveService {
    RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile curve);
    List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType);
    List<RecoveryCurveProfile> getAllCurves();
}
