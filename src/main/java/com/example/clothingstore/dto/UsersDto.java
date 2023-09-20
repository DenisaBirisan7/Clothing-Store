package com.example.clothingstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UsersDto {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String password;

    public UsersDto(String name, String address, String email, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }
}
