package com.temperature.tallerTemperatures.persistance.repository;

import com.temperature.tallerTemperatures.persistance.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
