package com.csc3700.agroguard.dto;

import com.csc3700.smartplant.model.Plant;
import com.csc3700.smartplant.model.Sensor;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class SensorDto {
    private Long   plantId;
    private float  soilMoisture;
    private float  temperature;
    private float  humidity;
    private LocalDateTime recordedAt;
    private String plantName;

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    // Getters & setters
    public Long getPlantId() { return plantId; }
    public void setPlantId(Long plantId) { this.plantId = plantId; }
    public float getSoilMoisture() { return soilMoisture; }
    public void setSoilMoisture(float soilMoisture) { this.soilMoisture = soilMoisture; }
    public float getTemperature() { return temperature; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    public float getHumidity() { return humidity; }
    public void setHumidity(float humidity) { this.humidity = humidity; }

    // Convert DTO → JPA entity
    public Sensor toEntity(Plant plant) {
        Sensor s = new Sensor();
        s.setPlant(plant);
        s.setSoilMoisture(soilMoisture);
        s.setTemperature(temperature);
        s.setHumidity(humidity);
        return s;
    }
    public static SensorDto fromEntity(Sensor sensor) {
        SensorDto dto = new SensorDto();
        dto.setSoilMoisture(sensor.getSoilMoisture());
        dto.setTemperature(sensor.getTemperature());
        dto.setHumidity(sensor.getHumidity());

        // Fixed timestamp conversion
        if (sensor.getRecordedAt() != null) {
            dto.setRecordedAt(LocalDateTime.ofInstant(
                    sensor.getRecordedAt().toInstant(),
                    ZoneId.systemDefault()
            ));
        }

        Plant plant = sensor.getPlant();
        dto.setPlantName(plant != null ? plant.getName() : "No plant");

        return dto;
    }
}