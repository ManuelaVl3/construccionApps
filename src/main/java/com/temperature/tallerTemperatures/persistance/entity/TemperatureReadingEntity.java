package com.temperature.tallerTemperatures.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="temperaturereading")

public class TemperatureReadingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float temperature;

    @Column(nullable = false)
    private LocalDateTime readingTime;

    @Column(nullable = false)
    private Integer deviceId;
}
