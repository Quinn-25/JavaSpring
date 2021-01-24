package com.example.projectdemo.controller;

import com.example.projectdemo.dto.request.UserRequestDto;
import com.example.projectdemo.dto.response.UserResponseDto;
import com.example.projectdemo.service.abstr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getUserList() {
        return userService.getUserList();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

}
