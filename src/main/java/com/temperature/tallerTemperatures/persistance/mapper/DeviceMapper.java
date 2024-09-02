package com.temperature.tallerTemperatures.persistance.mapper;

import com.temperature.tallerTemperatures.controller.request.DeviceRequest;
import com.temperature.tallerTemperatures.domain.Device;
import com.temperature.tallerTemperatures.persistance.entity.DeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toDomain(DeviceRequest deviceRequest);
    DeviceEntity toEntity(Device device);
    Device entityToDomain(DeviceEntity deviceEntity);
}
