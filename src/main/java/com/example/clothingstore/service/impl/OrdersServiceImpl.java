package com.example.clothingstore.service.impl;

import com.example.clothingstore.dao.OrdersRepository;
import com.example.clothingstore.dto.OrdersDto;
import com.example.clothingstore.entity.Orders;

import com.example.clothingstore.exception.OrderNotFoundException;
import com.example.clothingstore.service.OrdersService;
import com.example.clothingstore.service.ProductsService;
import com.example.clothingstore.service.UsersService;
import com.example.clothingstore.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final ProductsService productsService;
    private final UsersService customerService;


    @Override
    public List<OrdersDto> getAllOrders() {
        List<Orders> orders = ordersRepository.findAll();
        return orders.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));
        return EntityDtoConverter.toDto(order);
    }

    //to be seen!!
    @Override
    public OrdersDto saveOrder(OrdersDto orderDto) {
        Orders orders = EntityDtoConverter.toEntity(orderDto);
        Orders savedOrders = ordersRepository.save(orders);
        return EntityDtoConverter.toDto(savedOrders);
    }

    @Override
    public OrdersDto updateOrder(OrdersDto orderDto, Long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));
        order.setUnitPrice(orderDto.getUnitPrice());
        order.setTotalQuantity(orderDto.getTotalQuantity());
        order.setBillingAddress(orderDto.getBillingAddress());
        order.setStatus(orderDto.getStatus());

        Orders updatedOrder = ordersRepository.save(order);

        return EntityDtoConverter.toDto(updatedOrder);
    }

    @Override
    public void deleteOrderById(Long id) {
        ordersRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("order not found with id " + id));

        ordersRepository.deleteById(id);
    }
}
