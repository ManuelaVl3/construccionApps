package com.temperature.tallerTemperatures.persistance.mapper;

import com.temperature.tallerTemperatures.controller.request.TemperatureReadingRequest;
import com.temperature.tallerTemperatures.domain.TemperatureReading;
import com.temperature.tallerTemperatures.persistance.entity.TemperatureReadingEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemperatureReadingMapper {
    TemperatureReading toDomain(TemperatureReadingRequest temperatureReadingRequest);
    TemperatureReadingEntity toEntity(TemperatureReading temperatureReading);
    TemperatureReading entityToDomain(TemperatureReadingEntity temperatureReadingEntity);
}
