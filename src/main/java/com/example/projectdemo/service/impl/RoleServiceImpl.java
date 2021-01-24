package com.example.projectdemo.service.impl;

import com.example.projectdemo.dto.mapper.RoleMapper;
import com.example.projectdemo.dto.request.RoleRequestDto;
import com.example.projectdemo.dto.response.RoleResponseDto;
import com.example.projectdemo.model.Role;
import com.example.projectdemo.repository.RoleRepository;
import com.example.projectdemo.service.abstr.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfoNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity<List<RoleResponseDto>> getRoleList() {
        List<RoleResponseDto> roleResponseDtoList = RoleMapper.toListDto(roleRepository.findAll());

        return new ResponseEntity<>(roleResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoleResponseDto> getRole(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);

        if (!roleOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find role with id: %d", id));
        }

        Role role = roleOptional.get();

        return new ResponseEntity<>(RoleMapper.toDto(role), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoleResponseDto> createRole(RoleRequestDto roleRequestDto) {
        Role role = RoleMapper.createFromDto(roleRequestDto);

        role.setCreatedAt(new Date());
        role.setModifiedAt(new Date());

        Role createdRole = roleRepository.save(role);

        return new ResponseEntity<>(RoleMapper.toDto(createdRole), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoleResponseDto> updateRole(Long id, RoleRequestDto roleRequestDto) {
        Optional<Role> roleOptional = roleRepository.findById(id);

        if (!roleOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find role with id: %d", id));
        }

        Role role = roleOptional.get();

        Role updatedRole = RoleMapper.updateFromDto(role, roleRequestDto);

        updatedRole.setModifiedAt(new Date());

        roleRepository.save(updatedRole);

        return new ResponseEntity<>(RoleMapper.toDto(updatedRole), HttpStatus.OK);
    }
}
