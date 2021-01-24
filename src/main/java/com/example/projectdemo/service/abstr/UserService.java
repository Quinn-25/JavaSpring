package com.example.projectdemo.service.abstr;

import com.example.projectdemo.dto.request.UserRequestDto;
import com.example.projectdemo.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<List<UserResponseDto>> getUserList();

    ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto);

    ResponseEntity<UserResponseDto> updateUser(Long id, UserRequestDto userRequestDto);

    ResponseEntity<UserResponseDto> getUser(Long id);

}
