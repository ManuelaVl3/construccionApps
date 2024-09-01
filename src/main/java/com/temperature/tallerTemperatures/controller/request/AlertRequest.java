package com.temperature.tallerTemperatures.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlertRequest {

    @JsonProperty("message")
    private String message;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("deviceId")
    private Integer deviceId;

    @JsonProperty("user_id")
    private Integer userId;
}