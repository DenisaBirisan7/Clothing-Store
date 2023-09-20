package com.example.clothingstore.service.impl;

import com.example.clothingstore.dao.UsersRepository;
import com.example.clothingstore.dto.UsersDto;
import com.example.clothingstore.entity.Users;
import com.example.clothingstore.exception.UsersNotFoundException;
import com.example.clothingstore.service.UsersService;
import com.example.clothingstore.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUserById(Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException("User not found with id " + id));
        return EntityDtoConverter.toDto(users);
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        usersRepository.save(EntityDtoConverter.toEntity(usersDto));
        return usersDto;
    }

    @Override
    public UsersDto updateUser(UsersDto usersDto, Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException("User not found with id " + id));
        users.setName(usersDto.getName());
        users.setAddress(usersDto.getAddress());


        Users updatedUsers = usersRepository.save(users);
        return EntityDtoConverter.toDto(updatedUsers);
    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException("User not found with id " + id));

        usersRepository.deleteById(id);
    }




}