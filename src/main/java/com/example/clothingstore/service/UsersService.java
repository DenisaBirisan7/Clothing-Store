package com.example.clothingstore.service;

import com.example.clothingstore.dto.UsersDto;

import java.util.List;

public interface UsersService {
    List<UsersDto> getAllUsers();

    UsersDto getUserById(Long id);

    UsersDto saveUser(UsersDto userDto);

    UsersDto updateUser(UsersDto userDto, Long id);

    void deleteUserById(Long id);


}
