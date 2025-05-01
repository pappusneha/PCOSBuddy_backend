package com.pcos.buddy.backend.controllers;

import com.pcos.buddy.backend.model.SymptomLog;
import com.pcos.buddy.backend.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @PostMapping("/log")
    public ResponseEntity<SymptomLog> logSymptom(@RequestHeader("X-API-KEY") String apiKey, @RequestBody SymptomLog log) {
        return ResponseEntity.ok(symptomService.saveSymptomLog(log));
    }

    @GetMapping("/{userId}/history")
    public ResponseEntity<List<SymptomLog>> getSymptomHistory(@RequestHeader("X-API-KEY") String apiKey, @PathVariable String userId) {
        return ResponseEntity.ok(symptomService.getLogsByUser(userId));
    }
}