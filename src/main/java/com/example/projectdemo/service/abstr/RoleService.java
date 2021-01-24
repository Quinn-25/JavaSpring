package com.example.projectdemo.service.abstr;

import com.example.projectdemo.dto.request.RoleRequestDto;
import com.example.projectdemo.dto.response.RoleResponseDto;
import com.example.projectdemo.model.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    ResponseEntity<List<RoleResponseDto>> getRoleList();

    ResponseEntity<RoleResponseDto> getRole(Long id);

    ResponseEntity<RoleResponseDto> createRole(RoleRequestDto roleRequestDto);

    ResponseEntity<RoleResponseDto> updateRole(Long id, RoleRequestDto roleRequestDto);
}
