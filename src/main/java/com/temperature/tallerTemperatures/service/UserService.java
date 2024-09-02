package com.temperature.tallerTemperatures.service;

import com.temperature.tallerTemperatures.controller.request.UserRequest;
import com.temperature.tallerTemperatures.domain.User;
import com.temperature.tallerTemperatures.persistance.entity.UserEntity;
import com.temperature.tallerTemperatures.persistance.mapper.UserMapper;
import com.temperature.tallerTemperatures.persistance.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User getUser(Long id) {
        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isEmpty()) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }

        return userMapper.entityToDomain(userEntity.get());
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isEmpty()) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }

        this.userRepository.delete(userEntity.get());
    }

    public User updateUser(Long id, UserRequest userRequest) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        if (userRequest.getName() != null) {
            existingUser.setName(userRequest.getName());
        }
        if (userRequest.getPassword() != null) {
            existingUser.setPassword(userRequest.getPassword());
        }
        if (userRequest.getRole() != null) {
            existingUser.setRole(userRequest.getRole());
        }

        UserEntity updatedUser = userRepository.save(existingUser);

        return userMapper.entityToDomain(updatedUser);
    }
}
