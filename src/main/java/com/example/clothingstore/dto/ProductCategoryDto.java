package com.example.clothingstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductCategoryDto {
    private Long id;
    private String categoryName;
    private List<ProductsDto> productsDto;


    public ProductCategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
