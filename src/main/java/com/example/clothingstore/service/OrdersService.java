package com.example.clothingstore.service;

import com.example.clothingstore.dto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAllOrders();

     OrdersDto getOrderById(Long id);

    OrdersDto saveOrder(OrdersDto orderDto);

    OrdersDto updateOrder(OrdersDto orderDto, Long id);

    void deleteOrderById(Long id);
}
