package com.csc3700.agroguard.repository;

import com.csc3700.agroguard.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findTop10ByOrderByRecordedAtDesc();
}
