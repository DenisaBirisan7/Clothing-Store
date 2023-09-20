package com.example.clothingstore.service.impl;

import com.example.clothingstore.dao.ProductCategoryRepository;
import com.example.clothingstore.dto.ProductCategoryDto;

import com.example.clothingstore.entity.ProductCategory;
import com.example.clothingstore.exception.NotFoundException;
import com.example.clothingstore.exception.ProductNotFoundException;
import com.example.clothingstore.service.ProductCategoryService;
import com.example.clothingstore.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategoryDto> getAllProductCategory() {
        List<ProductCategory> productCategory = productCategoryRepository.findAll();
        return productCategory.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDto saveProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = EntityDtoConverter.toEntity(productCategoryDto);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return EntityDtoConverter.toDto(savedProductCategory);
    }

    @Override
    public ProductCategoryDto getProductCategoryById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product category not found with id " + id));
        return EntityDtoConverter.toDto(productCategory);
    }


    @Override
    public ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto, Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product category not found with id " + id));
        productCategory.setCategoryName(productCategoryDto.getCategoryName());

        ProductCategory updatedProductCategory = productCategoryRepository.save(productCategory);

        return EntityDtoConverter.toDto(updatedProductCategory);
    }


    @Override
    public void deleteProductCategoryById(Long id) {
        productCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        productCategoryRepository.deleteById(id);
    }


}
