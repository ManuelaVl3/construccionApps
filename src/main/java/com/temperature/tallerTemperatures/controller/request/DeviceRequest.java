package com.temperature.tallerTemperatures.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceRequest {

    @JsonProperty("location_id")
    private Integer locationId;

    @JsonProperty("status")
    private boolean status;
}
