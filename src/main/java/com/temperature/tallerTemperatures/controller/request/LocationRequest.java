package com.temperature.tallerTemperatures.controller.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequest {

    @JsonProperty("city")
    private String city;

    @JsonProperty("address")
    private String address;

}
