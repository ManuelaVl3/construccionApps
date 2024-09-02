package com.temperature.tallerTemperatures.persistance.mapper;

import com.temperature.tallerTemperatures.controller.request.UserRequest;
import com.temperature.tallerTemperatures.domain.User;
import com.temperature.tallerTemperatures.persistance.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserRequest userRequest);
    UserEntity toEntity(User user);
    User entityToDomain(UserEntity userEntity);
}
