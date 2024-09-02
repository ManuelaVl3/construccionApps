package com.temperature.tallerTemperatures.persistance.repository;

import com.temperature.tallerTemperatures.persistance.entity.TemperatureReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureReadingRepository extends JpaRepository<TemperatureReadingEntity, Long> {
}
