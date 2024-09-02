package com.temperature.tallerTemperatures.persistance.mapper;

import com.temperature.tallerTemperatures.controller.request.LocationRequest;
import com.temperature.tallerTemperatures.domain.Location;
import com.temperature.tallerTemperatures.persistance.entity.LocationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toDomain(LocationRequest locationRequest);
    LocationEntity toEntity(Location user);
    Location entityToDomain(LocationEntity locationEntity);
}
