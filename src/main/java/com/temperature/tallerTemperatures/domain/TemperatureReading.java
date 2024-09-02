package com.temperature.tallerTemperatures.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TemperatureReading {
    private int id;

    private float temperature;

    private LocalDateTime readingTime;

    private Device device;
}
