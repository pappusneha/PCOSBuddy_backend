package com.pcos.buddy.backend.controllers;

import com.pcos.buddy.backend.model.WellnessLog;
import com.pcos.buddy.backend.service.WellnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wellness")
public class WellnessController {
    @Autowired
    private WellnessService wellnessService;

    @PostMapping("/log")
    public ResponseEntity logWellness(@RequestHeader("X-API-KEY") String apiKey, @RequestBody WellnessLog log) {
        return ResponseEntity.ok(wellnessService.saveWellnessLog(log));
    }

    @GetMapping("/{userId}/history")
    public ResponseEntity<List<WellnessLog>> getWellnessHistory(@RequestHeader("X-API-KEY") String apiKey, @PathVariable String userId) {
        return ResponseEntity.ok(wellnessService.getLogsByUser(userId));
    }

}
