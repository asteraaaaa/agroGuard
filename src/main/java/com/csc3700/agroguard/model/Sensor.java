package com.csc3700.agroguard.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float soilMoisture;
    private float temperature;
    private float humidity;
    private Timestamp recordedAt = Timestamp.from(Instant.now());

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public float getSoilMoisture() { return soilMoisture; }
    public void setSoilMoisture(float soilMoisture) { this.soilMoisture = soilMoisture; }
    public float getTemperature() { return temperature; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    public float getHumidity() { return humidity; }
    public void setHumidity(float humidity) { this.humidity = humidity; }
    public Timestamp getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Timestamp recordedAt) { this.recordedAt = recordedAt; }
}

