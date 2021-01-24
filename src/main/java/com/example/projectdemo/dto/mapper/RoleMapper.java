package com.example.projectdemo.dto.mapper;

import com.example.projectdemo.dto.request.RoleRequestDto;
import com.example.projectdemo.dto.response.RoleResponseDto;
import com.example.projectdemo.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleMapper {

    private RoleMapper() {}

    public static RoleResponseDto toDto(Role role) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();

        roleResponseDto.setId(role.getId());
        roleResponseDto.setCreatedAt(role.getCreatedAt().toInstant().getEpochSecond());
        roleResponseDto.setModifiedAt(role.getModifiedAt().toInstant().getEpochSecond());
        roleResponseDto.setCreatedBy(role.getCreatedBy());
        roleResponseDto.setModifiedBy(role.getModifiedBy());
        roleResponseDto.setName(role.getName());
        roleResponseDto.setCode(role.getCode());

        return roleResponseDto;
    }

    public static List<RoleResponseDto> toListDto(List<Role> roleList) {
        List<RoleResponseDto> roleResponseDtoList = new ArrayList<>();

        for (Role roleItem : roleList) {
            roleResponseDtoList.add(toDto(roleItem));
        }

        return roleResponseDtoList;
    }

    public static Role createFromDto(RoleRequestDto roleRequestDto) {
        Role role = new Role();

        role.setCreatedBy(roleRequestDto.getCreatedBy());
        role.setModifiedBy(roleRequestDto.getModifiedBy());
        role.setName(roleRequestDto.getName());
        role.setCode(roleRequestDto.getCode());

        return role;
    }

    public static Role updateFromDto(Role role, RoleRequestDto roleRequestDto) {
        if (roleRequestDto.getCreatedBy() != null) {
            role.setCreatedBy(roleRequestDto.getCreatedBy());
        }
        role.setCreatedBy(roleRequestDto.getCreatedBy());

        if (roleRequestDto.getModifiedBy() != null) {
            role.setModifiedBy(roleRequestDto.getModifiedBy());
        }
        role.setModifiedBy(roleRequestDto.getModifiedBy());

        if (roleRequestDto.getName() != null) {
            role.setName(roleRequestDto.getName());
        }
        role.setName(roleRequestDto.getName());

        if (roleRequestDto.getCode() != null) {
            role.setCode(roleRequestDto.getCode());
        }

        return role;
    }
}
