package com.example.clothingstore.service.impl;

import com.example.clothingstore.dao.OrderItemsRepository;
import com.example.clothingstore.dto.OrderItemsDto;
import com.example.clothingstore.dto.OrdersDto;
import com.example.clothingstore.entity.OrderItems;
import com.example.clothingstore.entity.Orders;
import com.example.clothingstore.exception.OrderNotFoundException;
import com.example.clothingstore.service.OrderItemsService;
import com.example.clothingstore.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {
    private final OrderItemsRepository ordersItemsRepository;

    @Override
    public List<OrderItemsDto> getAllOrderItems() {
        List<OrderItems> orderItems = ordersItemsRepository.findAll();
        return orderItems.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemsDto getOrderItemsById(Long id) {
        OrderItems orderItems = ordersItemsRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order items not found with id " + id));
        return EntityDtoConverter.toDto(orderItems);
    }


    @Override
    public OrderItemsDto saveOrderItems(OrderItemsDto orderItemsDto) {
        OrderItems ordersItems = EntityDtoConverter.toEntity(orderItemsDto);
        OrderItems savedOrdersItems = ordersItemsRepository.save(ordersItems);
        return EntityDtoConverter.toDto(savedOrdersItems);
    }

    @Override
    public OrderItemsDto updateOrderItems(OrderItemsDto orderItemsDto, Long id) {
        OrderItems orderItems = ordersItemsRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order items not found with id " + id));
        orderItems.setUnitPrice(orderItemsDto.getUnitPrice());
        orderItems.setImageUrl(orderItemsDto.getImageUrl());
        orderItems.setQuantity(orderItemsDto.getQuantity());


        OrderItems updatedOrderItems = ordersItemsRepository.save(orderItems);

        return EntityDtoConverter.toDto(updatedOrderItems);
    }

    @Override
    public void deleteOrderItemsById(Long id) {
        ordersItemsRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order items not found with id " + id));

        ordersItemsRepository.deleteById(id);
    }


}
