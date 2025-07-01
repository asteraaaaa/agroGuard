package com.csc3700.agroguard.dto;

public class SensorDto {
    private float soilMoisture;
    private float temperature;
    private float humidity;

    // Getters and setters
    public float getSoilMoisture() { return soilMoisture; }
    public void setSoilMoisture(float soilMoisture) { this.soilMoisture = soilMoisture; }
    public float getTemperature() { return temperature; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    public float getHumidity() { return humidity; }
    public void setHumidity(float humidity) { this.humidity = humidity; }
}
