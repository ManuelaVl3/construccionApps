package com.temperature.tallerTemperatures.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TemperatureReadingRequest {

    @JsonProperty("temperature")
    private float temperature;

    @JsonProperty("reading_time")
    private LocalDateTime readingTime;

    @JsonProperty("device_id")
    private Integer deviceId;
}
