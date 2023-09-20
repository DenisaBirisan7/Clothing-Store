package com.example.clothingstore.service;

import com.example.clothingstore.dto.OrderItemsDto;
import com.example.clothingstore.dto.OrdersDto;

import java.util.List;

public interface OrderItemsService {
    List<OrderItemsDto> getAllOrderItems();

    OrderItemsDto getOrderItemsById(Long id);

    OrderItemsDto saveOrderItems(OrderItemsDto orderItemsDto);

    OrderItemsDto updateOrderItems(OrderItemsDto orderItemsDto, Long id);

    void deleteOrderItemsById(Long id);

    //to be seen!!

}
