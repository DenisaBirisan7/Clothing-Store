package com.example.clothingstore.controller;

import com.example.clothingstore.dto.OrderItemsDto;
import com.example.clothingstore.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderItems")
@RequiredArgsConstructor
public class OrderItemsController {
    private final OrderItemsService orderItemsService;

    @PostMapping("/addOrderItems")
    public ResponseEntity<OrderItemsDto> saveOrderItems(@RequestBody OrderItemsDto orderItemsDto) {
        OrderItemsDto savedOrderItems = orderItemsService.saveOrderItems(orderItemsDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Order items created successfully.")
                .body(savedOrderItems);
    }

    @GetMapping("/getAllOrderItems")
    public ResponseEntity<List<OrderItemsDto>> getAllOrderItems() {
        List<OrderItemsDto> orderItems = orderItemsService.getAllOrderItems();

        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{orderItemsId}")
    public ResponseEntity<OrderItemsDto> getOrderItemsById(@PathVariable("orderItemsId") Long orderItemsId) {
        OrderItemsDto orderItemsById = orderItemsService.getOrderItemsById(orderItemsId);

        return new ResponseEntity<>(orderItemsById, HttpStatus.OK);
    }

    @PutMapping("/{orderItemsId}")
    public ResponseEntity<OrderItemsDto> updateOrderItems(@PathVariable("orderItemsId") Long orderItemsId,
                                                 @RequestBody OrderItemsDto orderItemsDto) {
        OrderItemsDto updatedOrderItems = orderItemsService.updateOrderItems(orderItemsDto, orderItemsId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Order items updated successfully.")
                .body(updatedOrderItems);
    }

    @DeleteMapping("/{orderItemsId}")
    public ResponseEntity<Void> deleteOrderItemsById(@PathVariable("orderItemsId") Long orderItemsId) {
        orderItemsService.deleteOrderItemsById(orderItemsId);

        return ResponseEntity.noContent()
                .header("Message", "Order items deleted successfully.")
                .build();
    }

}
