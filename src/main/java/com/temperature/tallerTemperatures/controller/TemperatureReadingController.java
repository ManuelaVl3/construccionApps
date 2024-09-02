package com.temperature.tallerTemperatures.controller;

import com.temperature.tallerTemperatures.controller.request.TemperatureReadingRequest;
import com.temperature.tallerTemperatures.controller.response.Response;
import com.temperature.tallerTemperatures.domain.TemperatureReading;
import com.temperature.tallerTemperatures.service.TemperatureReadingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
@AllArgsConstructor
public class TemperatureReadingController {

    private final TemperatureReadingService temperatureReadingService;

    @PostMapping()
    public ResponseEntity<Response> postTemperatureReading(@RequestBody TemperatureReadingRequest temperatureRequest) {
        TemperatureReading reading = temperatureReadingService.saveTemperatureReading(temperatureRequest);
        return new ResponseEntity<>(new Response("Temperature reading was created successfully with ID: " + reading.getId()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<TemperatureReading> getTemperatureReading(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(temperatureReadingService.getTemperatureReading(id), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteTemperatureReading(@RequestParam(name = "id") Long id) {
        temperatureReadingService.deleteTemperatureReading(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity<Response> updateTemperatureReading(
            @RequestParam(name = "id") Long id,
            @RequestBody TemperatureReadingRequest temperatureRequest
    ) {
        TemperatureReading reading = temperatureReadingService.updateTemperatureReading(id, temperatureRequest);
        return new ResponseEntity<>(new Response("Temperature reading was updated successfully with ID: " + reading.getId()), HttpStatus.OK);
    }
}