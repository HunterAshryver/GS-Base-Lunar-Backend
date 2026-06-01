package com.fiap.lunar_base_monitoring.repository;

import com.fiap.lunar_base_monitoring.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
