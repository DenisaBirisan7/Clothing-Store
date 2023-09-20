package com.example.clothingstore.controller;

import com.example.clothingstore.dto.ProductsDto;
import com.example.clothingstore.dto.UsersDto;
import com.example.clothingstore.service.UsersService;
import com.example.clothingstore.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ap/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    @PostMapping("/add")
    public ResponseEntity<UsersDto> saveUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUser = usersService.saveUser(usersDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "User created successfully.")
                .body(savedUser);
    }


    @GetMapping("/allUsers")
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    //GET BY ID REQUEST
    @GetMapping("/{userId}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("userId") Long userId) {
        UsersDto userById = usersService.getUserById(userId);

        return new ResponseEntity<>(userById, HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable("userId") Long userId,
                                                      @RequestBody UsersDto userDto) {
        UsersDto updatedUser = usersService.updateUser(userDto, userId);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "User updated successfully.")
                .body(updatedUser);
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) {
        usersService.deleteUserById(userId);

        return ResponseEntity.ok("Product was deleted successfully!");
    }



}
