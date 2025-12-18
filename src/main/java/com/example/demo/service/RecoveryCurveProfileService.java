package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import java.util.List;

public interface RecoveryCurveProfileService {

    RecoveryCurveProfile create(RecoveryCurveProfile profile);

    List<RecoveryCurveProfile> getAll();

    RecoveryCurveProfile getById(Long id);

    RecoveryCurveProfile update(Long id, RecoveryCurveProfile profile);

    void delete(Long id);
}
