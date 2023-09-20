package com.example.clothingstore.utils;

import com.example.clothingstore.dto.*;
import com.example.clothingstore.entity.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDtoConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Users toEntity(UsersDto userDto) {
        return modelMapper.map(userDto, Users.class);
    }

    public static UsersDto toDto(Users user) {
        return modelMapper.map(user, UsersDto.class);
    }

    public static Orders toEntity(OrdersDto orderDto) {
        return modelMapper.map(orderDto, Orders.class);
    }

    public static OrdersDto toDto(Orders order) {
        return modelMapper.map(order, OrdersDto.class);
    }

    public static Products toEntity(ProductsDto productDto) {
        return modelMapper.map(productDto, Products.class);
    }

    public static ProductsDto toDto(Products product) {
        return modelMapper.map(product, ProductsDto.class);
    }

    public static ProductCategoryDto toDto(ProductCategory productCategory) {return modelMapper.map(productCategory, ProductCategoryDto.class);}

    public static ProductCategory toEntity(ProductCategoryDto productCategoryDto) {
        return modelMapper.map(productCategoryDto, ProductCategory.class);
    }

    public static List<Products> toEntityList(List<ProductsDto> productDTOs) {
        return productDTOs.stream()
                .map(EntityDtoConverter::toEntity) // Use the existing toEntity method to convert each DTO to its corresponding entity
                .collect(Collectors.toList());
    }

    public static OrderItemsDto toDto(OrderItems orderItems) {return modelMapper.map(orderItems, OrderItemsDto.class);
    }
    public static OrderItems toEntity(OrderItemsDto orderItemsDto) {
        return modelMapper.map(orderItemsDto, OrderItems.class);
    }
}
