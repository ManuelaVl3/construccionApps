package com.temperature.tallerTemperatures.controller;

import com.temperature.tallerTemperatures.controller.request.UserRequest;
import com.temperature.tallerTemperatures.controller.response.UserResponse;
import com.temperature.tallerTemperatures.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponse> postUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        return new ResponseEntity<>(new UserResponse("User was created successfully " + userRequest.getName()), HttpStatus.OK);
    }

}
