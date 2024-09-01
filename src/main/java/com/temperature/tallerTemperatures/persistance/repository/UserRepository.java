package com.temperature.tallerTemperatures.persistance.repository;

import com.temperature.tallerTemperatures.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
