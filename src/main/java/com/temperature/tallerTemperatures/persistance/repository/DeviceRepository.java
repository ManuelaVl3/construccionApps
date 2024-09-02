package com.temperature.tallerTemperatures.persistance.repository;

import com.temperature.tallerTemperatures.persistance.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
}
