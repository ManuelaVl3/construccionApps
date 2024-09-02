package com.temperature.tallerTemperatures.controller;

import com.temperature.tallerTemperatures.controller.request.DeviceRequest;
import com.temperature.tallerTemperatures.controller.response.Response;
import com.temperature.tallerTemperatures.domain.Device;
import com.temperature.tallerTemperatures.service.DeviceService;
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
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping()
    public ResponseEntity<Response> postDevice(@RequestBody DeviceRequest deviceRequest) {
        Device device = deviceService.saveDevice(deviceRequest);
        return new ResponseEntity<>(new Response("Device was created successfully " + device.getName() + " With ID: " + device.getId()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Device> getDevice(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(deviceService.getDevice(id), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteDevice(@RequestParam(name = "id") Long id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity<Response> updateDevice(
            @RequestParam(name = "id") Long id,
            @RequestBody DeviceRequest deviceRequest
    ) {
        Device device = deviceService.updateDevice(id, deviceRequest);
        return new ResponseEntity<>(new Response("Device was updated successfully " + device.getName() + " With ID: " + device.getId()), HttpStatus.OK);
    }
}