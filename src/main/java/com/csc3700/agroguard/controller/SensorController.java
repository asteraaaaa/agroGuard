package com.csc3700.agroguard.controller;

import com.csc3700.agroguard.dto.SensorDto;
import com.csc3700.agroguard.model.Sensor;
import com.csc3700.agroguard.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<String> ingest(@RequestBody SensorDto dto) {
        sensorService.ingest(dto);
        return ResponseEntity.ok("Sensor data received");
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getRecent() {
        return ResponseEntity.ok(sensorService.getRecentReadings());
    }

    @GetMapping("/latest")
    @ResponseBody
    public Sensor getLatestSensor() {
        List<Sensor> recent = sensorService.getRecentReadings();
        return recent.isEmpty() ? null : recent.get(0);
    }

    @GetMapping("/recent")
    @ResponseBody
    public List<Sensor> getRecentSensors() {
        return sensorService.getRecentReadings();
    }

    @GetMapping("/thresholds")
    public Map<String, Object> getPlantThresholds() {
        Map<String, Object> thresholds = new HashMap<>();
        thresholds.put("minMoisture", 30);
        thresholds.put("maxMoisture", 60);
        thresholds.put("minTemperature", 18);
        thresholds.put("maxTemperature", 30);
        thresholds.put("minHumidity", 40);
        thresholds.put("maxHumidity", 70);
        return thresholds;
    }

}

