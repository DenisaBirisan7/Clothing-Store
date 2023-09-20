package com.example.clothingstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductsDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private int unitsInStock;
    private List<OrderItemsDto> orderItemsDto;

    public ProductsDto(String name, String description, BigDecimal unitPrice, String imageUrl, int unitsInStock) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.unitsInStock = unitsInStock;
    }
}
