package com.example.projectdemo.controller;

import com.example.projectdemo.dto.request.RoleRequestDto;
import com.example.projectdemo.service.abstr.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getRoleList() {
        return roleService.getRoleList();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createRole(@RequestBody RoleRequestDto roleRequestDto) {
        return roleService.createRole(roleRequestDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody RoleRequestDto roleRequestDto) {
        return roleService.updateRole(id, roleRequestDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getRole(@PathVariable("id") Long id) {
        return roleService.getRole(id);
    }
}
