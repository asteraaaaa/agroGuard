package com.csc3700.agroguard.controller;

import com.csc3700.agroguard.model.Sensor;
import com.csc3700.agroguard.service.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final SensorService sensorService;

    public DashboardController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        List<Sensor> recent = sensorService.getRecentReadings();
        Sensor latest = recent.isEmpty() ? null : recent.get(0);

        model.addAttribute("latest", latest);
        model.addAttribute("records", recent);
        return "dashboard";
    }
}
