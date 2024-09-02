package com.temperature.tallerTemperatures.service;

import com.temperature.tallerTemperatures.controller.request.TemperatureReadingRequest;
import com.temperature.tallerTemperatures.domain.TemperatureReading;
import com.temperature.tallerTemperatures.persistance.entity.DeviceEntity;
import com.temperature.tallerTemperatures.persistance.entity.TemperatureReadingEntity;
import com.temperature.tallerTemperatures.persistance.mapper.TemperatureReadingMapper;
import com.temperature.tallerTemperatures.persistance.repository.DeviceRepository;
import com.temperature.tallerTemperatures.persistance.repository.TemperatureReadingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TemperatureReadingService {

    private final TemperatureReadingMapper temperatureReadingMapper;
    private final TemperatureReadingRepository temperatureReadingRepository;
    private final DeviceRepository deviceRepository;

    public TemperatureReading saveTemperatureReading(TemperatureReadingRequest temperatureRequest) {
        TemperatureReading readingDomain = temperatureReadingMapper.toDomain(temperatureRequest);

        DeviceEntity device = deviceRepository.findById(temperatureRequest.getDeviceId())
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + temperatureRequest.getDeviceId()));

        TemperatureReadingEntity readingEntity = new TemperatureReadingEntity();
        readingEntity.setTemperature(readingDomain.getTemperature());
        readingEntity.setReadingTime(readingDomain.getReadingTime());
        readingEntity.setDevice(device);

        temperatureReadingRepository.save(readingEntity);

        return temperatureReadingMapper.entityToDomain(readingEntity);
    }

    public TemperatureReading getTemperatureReading(Long id) {
        TemperatureReadingEntity readingEntity = this.temperatureReadingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature reading not found with id " + id));

        return temperatureReadingMapper.entityToDomain(readingEntity);
    }

    public void deleteTemperatureReading(Long id) {
        TemperatureReadingEntity readingEntity = this.temperatureReadingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature reading not found with id " + id));

        this.temperatureReadingRepository.delete(readingEntity);
    }

    public TemperatureReading updateTemperatureReading(Long id, TemperatureReadingRequest temperatureRequest) {
        TemperatureReadingEntity existingReading = temperatureReadingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature reading not found with id " + id));

        if (temperatureRequest.getTemperature() != 0) {
            existingReading.setTemperature(temperatureRequest.getTemperature());
        }
        if (temperatureRequest.getReadingTime() != null) {
            existingReading.setReadingTime(temperatureRequest.getReadingTime());
        }
        if (temperatureRequest.getDeviceId() != null) {
            DeviceEntity device = deviceRepository.findById(temperatureRequest.getDeviceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + temperatureRequest.getDeviceId()));
            existingReading.setDevice(device);
        }

        TemperatureReadingEntity updatedReading = temperatureReadingRepository.save(existingReading);

        return temperatureReadingMapper.entityToDomain(updatedReading);
    }
}