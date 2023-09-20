package com.example.clothingstore.controller;

import com.example.clothingstore.dto.OrdersDto;

import com.example.clothingstore.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<OrdersDto> saveOrder(@RequestBody OrdersDto orderDto) {
        OrdersDto savedOrder = orderService.saveOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Order created successfully.")
                .body(savedOrder);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdersDto>> getAllOrders() {
        List<OrdersDto> orders = orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{ordersId}")
    public ResponseEntity<OrdersDto> getOrderById(@PathVariable("orderId") Long orderId) {
        OrdersDto orderById = orderService.getOrderById(orderId);

        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrdersDto> updateOrder(@PathVariable("orderId") Long orderId,
                                                     @RequestBody OrdersDto orderDto) {
        OrdersDto updatedOrder = orderService.updateOrder(orderDto, orderId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Order updated successfully.")
                .body(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrderById(orderId);

        return ResponseEntity.noContent()
                .header("Message", "Order deleted successfully.")
                .build();
    }

}
