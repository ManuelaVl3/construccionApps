package com.temperature.tallerTemperatures.service;

import com.temperature.tallerTemperatures.controller.request.LocationRequest;
import com.temperature.tallerTemperatures.domain.Location;
import com.temperature.tallerTemperatures.persistance.entity.LocationEntity;
import com.temperature.tallerTemperatures.persistance.mapper.LocationMapper;
import com.temperature.tallerTemperatures.persistance.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;

    public Location saveLocation(LocationRequest locationRequest) {
        Location userDomain = locationMapper.toDomain(locationRequest);
        LocationEntity userEntity = locationMapper.toEntity(userDomain);
        locationRepository.save(userEntity);

        return userDomain;
    }

    public Location getLocation(Long id) {
        Optional<LocationEntity> userEntity = this.locationRepository.findById(id);

        if (userEntity.isEmpty()) {
            throw new ResourceNotFoundException("Location not found with id " + id);
        }

        return locationMapper.entityToDomain(userEntity.get());
    }

    public void deleteLocation(Long id) {
        Optional<LocationEntity> userEntity = this.locationRepository.findById(id);

        if (userEntity.isEmpty()) {
            throw new ResourceNotFoundException("Location not found with id " + id);
        }

        this.locationRepository.delete(userEntity.get());
    }

    public Location updateLocation(Long id, LocationRequest locationRequest) {
        LocationEntity existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + id));

        if (locationRequest.getCity() != null) {
            existingLocation.setCity(locationRequest.getCity());
        }
        if (locationRequest.getAddress() != null) {
            existingLocation.setAddress(locationRequest.getAddress());
        }

        LocationEntity updatedLocation = locationRepository.save(existingLocation);

        return locationMapper.entityToDomain(updatedLocation);
    }
}
