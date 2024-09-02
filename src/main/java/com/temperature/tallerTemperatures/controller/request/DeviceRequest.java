package com.temperature.tallerTemperatures.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;
}
