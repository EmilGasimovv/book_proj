package com.example.ingressacademytask.services;

import com.example.ingressacademytask.dto.UserDto;
import com.example.ingressacademytask.dto.UserRequest;
import com.example.ingressacademytask.dto.UserResponse;

public interface  UserService {
    UserDto createUser(UserDto userDto);

    UserResponse loginUser(UserRequest userRequest);
}