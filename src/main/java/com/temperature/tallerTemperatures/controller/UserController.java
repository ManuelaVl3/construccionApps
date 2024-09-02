package com.temperature.tallerTemperatures.controller;

import com.temperature.tallerTemperatures.controller.request.UserRequest;
import com.temperature.tallerTemperatures.controller.response.Response;
import com.temperature.tallerTemperatures.domain.User;
import com.temperature.tallerTemperatures.service.UserService;
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
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Response> postUser(@RequestBody UserRequest userRequest) {
        User user = userService.saveUser(userRequest);
        return new ResponseEntity<>(new Response("User was created successfully " + user.getName() + " With ID: " + user.getId()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<User> getUser(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity<Response> updateUser(
            @RequestParam(name = "id") Long id,
            @RequestBody UserRequest userRequest
    ) {
        User user = userService.updateUser(id, userRequest);
        return new ResponseEntity<>(new Response("User was updated successfully " + user.getName() + " With ID: " + user.getId()), HttpStatus.OK);
    }

}
