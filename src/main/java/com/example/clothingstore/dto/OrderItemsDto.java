package com.example.clothingstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
public class OrderItemsDto {
    private Long id;
    private String imageUrl;
    private int quantity;
    private BigDecimal unitPrice;


    public OrderItemsDto(String imageUrl, int quantity, BigDecimal unitPrice) {
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
