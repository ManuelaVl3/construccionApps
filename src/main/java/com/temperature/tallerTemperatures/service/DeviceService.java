package com.temperature.tallerTemperatures.service;

import com.temperature.tallerTemperatures.controller.request.DeviceRequest;
import com.temperature.tallerTemperatures.domain.Device;
import com.temperature.tallerTemperatures.persistance.entity.DeviceEntity;
import com.temperature.tallerTemperatures.persistance.mapper.DeviceMapper;
import com.temperature.tallerTemperatures.persistance.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceService {

    private final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;

    public Device saveDevice(DeviceRequest deviceRequest) {
        Device deviceDomain = deviceMapper.toDomain(deviceRequest);
        DeviceEntity deviceEntity = deviceMapper.toEntity(deviceDomain);
        deviceRepository.save(deviceEntity);

        return deviceDomain;
    }

    public Device getDevice(Long id) {
        Optional<DeviceEntity> deviceEntity = this.deviceRepository.findById(id);

        if (deviceEntity.isEmpty()) {
            throw new ResourceNotFoundException("Device not found with id " + id);
        }

        return deviceMapper.entityToDomain(deviceEntity.get());
    }

    public void deleteDevice(Long id) {
        Optional<DeviceEntity> deviceEntity = this.deviceRepository.findById(id);

        if (deviceEntity.isEmpty()) {
            throw new ResourceNotFoundException("Device not found with id " + id);
        }

        this.deviceRepository.delete(deviceEntity.get());
    }

    public Device updateDevice(Long id, DeviceRequest deviceRequest) {
        DeviceEntity existingLocation = deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id));

        if (deviceRequest.getName() != null) {
            existingLocation.setName(deviceRequest.getName());
        }
        if (deviceRequest.getDescription() != null) {
            existingLocation.setDescription(deviceRequest.getDescription());
        }

        DeviceEntity updatedLocation = deviceRepository.save(existingLocation);

        return deviceMapper.entityToDomain(updatedLocation);
    }
}
