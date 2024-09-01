package com.temperature.tallerTemperatures.service;

import com.temperature.tallerTemperatures.controller.request.UserRequest;
import com.temperature.tallerTemperatures.domain.User;
import com.temperature.tallerTemperatures.persistance.entity.UserEntity;
import com.temperature.tallerTemperatures.persistance.mapper.UserMapper;
import com.temperature.tallerTemperatures.persistance.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User userDomain = userMapper.toDomain(userRequest);
        UserEntity userEntity = userMapper.toEntity(userDomain);
        userRepository.save(userEntity);

        return userDomain;
    }
}
