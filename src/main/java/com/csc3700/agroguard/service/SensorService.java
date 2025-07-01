package com.csc3700.agroguard.service;

import com.csc3700.agroguard.dto.SensorDto;
import com.csc3700.agroguard.model.Sensor;
import com.csc3700.agroguard.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void ingest(SensorDto dto) {
        Sensor sensor = new Sensor();
        sensor.setSoilMoisture(dto.getSoilMoisture());
        sensor.setTemperature(dto.getTemperature());
        sensor.setHumidity(dto.getHumidity());
        sensorRepository.save(sensor);
    }

    public List<Sensor> getRecentReadings() {
        return sensorRepository.findTop10ByOrderByRecordedAtDesc();
    }
}

