package com.temperature.tallerTemperatures.controller;

import com.temperature.tallerTemperatures.controller.request.LocationRequest;
import com.temperature.tallerTemperatures.controller.response.Response;
import com.temperature.tallerTemperatures.domain.Location;
import com.temperature.tallerTemperatures.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping()
    public ResponseEntity<Response> postLocation(@RequestBody LocationRequest locationRequest) {
        Location location = locationService.saveLocation(locationRequest);
        return new ResponseEntity<>(new Response("Location was created successfully " + location.getAddress() + " With ID: " + location.getId()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Location> getLocation(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(locationService.getLocation(id), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteLocation(@RequestParam(name = "id") Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity<Response> updateLocation(
            @RequestParam(name = "id") Long id,
            @RequestBody LocationRequest locationRequest
    ) {
        Location location = locationService.updateLocation(id, locationRequest);
        return new ResponseEntity<>(new Response("Location was updated successfully " + location.getAddress() + " With ID: " + location.getId()), HttpStatus.OK);
    }
}
