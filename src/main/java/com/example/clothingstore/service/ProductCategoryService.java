package com.example.clothingstore.service;

import com.example.clothingstore.dto.ProductCategoryDto;
import com.example.clothingstore.dto.ProductsDto;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getAllProductCategory();

    ProductCategoryDto getProductCategoryById(Long id);

    ProductCategoryDto saveProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto, Long id);

    void deleteProductCategoryById(Long id);

}
