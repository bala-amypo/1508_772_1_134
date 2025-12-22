package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveProfileController {
    private final RecoveryCurveProfileService service;
    public RecoveryCurveProfileController(RecoveryCurveProfileService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> create(
            @RequestBody RecoveryCurveProfile profile) {
        return new ResponseEntity<>(service.create(profile), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RecoveryCurveProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RecoveryCurveProfile> update(
            @PathVariable Long id,
            @RequestBody RecoveryCurveProfile profile) {
        return ResponseEntity.ok(service.update(id, profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
