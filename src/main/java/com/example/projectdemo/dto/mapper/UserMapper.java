package com.example.projectdemo.dto.mapper;

import com.example.projectdemo.dto.request.UserRequestDto;
import com.example.projectdemo.dto.response.UserResponseDto;
import com.example.projectdemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private UserMapper() {}

    public static UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setCreatedAt(user.getCreatedAt().toInstant().getEpochSecond());
        userResponseDto.setModifiedAt(user.getModifiedAt().toInstant().getEpochSecond());
        userResponseDto.setCreatedBy(user.getCreatedBy());
        userResponseDto.setModifiedBy(user.getModifiedBy());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setFullName(user.getFullName());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setStatus(user.getStatus());
        userResponseDto.setRoleId(user.getRoleId());

        return userResponseDto;
    }

    public static List<UserResponseDto> toListDto(List<User> userList) {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for (User userItem : userList) {
            userResponseDtoList.add(toDto(userItem));
        }

        return userResponseDtoList;
    }

    public static User createFromDto(UserRequestDto userRequestDto) {
        User user = new User();

        user.setCreatedBy(userRequestDto.getCreatedBy());
        user.setModifiedBy(userRequestDto.getModifiedBy());
        user.setUsername(userRequestDto.getUserName());
        user.setFullName(userRequestDto.getFullName());
        user.setPassword(userRequestDto.getPassword());
        user.setStatus(userRequestDto.getStatus());
        user.setRoleId(userRequestDto.getRoleId());

        return user;
    }

    public static User updateFromDto(User user,  UserRequestDto userRequestDto) {
        if (userRequestDto.getCreatedBy() != null) {
            user.setCreatedBy(userRequestDto.getCreatedBy());
        }

        if (userRequestDto.getModifiedBy() != null) {
            user.setModifiedBy(userRequestDto.getModifiedBy());
        }

        if (userRequestDto.getUserName() != null) {
            user.setUsername(userRequestDto.getUserName());
        }

        if (userRequestDto.getFullName() != null) {
            user.setFullName(userRequestDto.getFullName());
        }

        if (userRequestDto.getStatus() != null) {
            user.setStatus(userRequestDto.getStatus());
        }

        if (userRequestDto.getPassword() != null) {
            user.setPassword(userRequestDto.getPassword());
        }

        if (userRequestDto.getRoleId() != null){
            user.setRoleId(userRequestDto.getRoleId());
        }

        return user;
    }
}
