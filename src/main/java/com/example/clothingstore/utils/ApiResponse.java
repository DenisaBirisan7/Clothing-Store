package com.example.clothingstore.utils;

import lombok.Data;

@Data
public class ApiResponse<T>{

    private String message;
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
