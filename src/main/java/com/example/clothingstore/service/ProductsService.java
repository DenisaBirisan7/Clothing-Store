package com.example.clothingstore.service;

import com.example.clothingstore.dto.ProductsDto;

import java.util.List;

public interface ProductsService {
    List<ProductsDto> getAllProducts();

    ProductsDto getProductById(Long id);

    ProductsDto saveProduct(ProductsDto productDto);

    ProductsDto updateProduct(ProductsDto productDto, Long id);


    void deleteProductById(Long id);
}
