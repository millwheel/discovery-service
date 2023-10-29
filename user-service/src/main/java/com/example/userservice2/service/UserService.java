package com.example.userservice2.service;

import com.example.userservice2.dto.UserDto;
import com.example.userservice2.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserDto> getUserByAll();
}
