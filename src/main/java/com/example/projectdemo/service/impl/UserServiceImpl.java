package com.example.projectdemo.service.impl;

import com.example.projectdemo.dto.mapper.UserMapper;
import com.example.projectdemo.dto.request.UserRequestDto;
import com.example.projectdemo.dto.response.UserResponseDto;
import com.example.projectdemo.model.User;
import com.example.projectdemo.repository.UserRepository;
import com.example.projectdemo.service.abstr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<List<UserResponseDto>> getUserList() {
        List<UserResponseDto> userResponseDtoList = UserMapper.toListDto(userRepository.findAll());

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto) {
        User user = UserMapper.createFromDto(userRequestDto);

        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());

        userRepository.save(user);

        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUser(Long id, UserRequestDto userRequestDto) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find user with id: %d", id));
        }

        User user = userOptional.get();

        User updateUser = UserMapper.updateFromDto(user, userRequestDto);

        updateUser.setModifiedAt(new Date());

        userRepository.save(updateUser);

        return new ResponseEntity<>(UserMapper.toDto(updateUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDto> getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find user with id: %d", id));
        }

        User user = userOptional.get();

        return  new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }
}
