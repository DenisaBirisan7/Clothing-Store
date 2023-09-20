package com.example.clothingstore.service.impl;

import com.example.clothingstore.dao.ProductsRepository;
import com.example.clothingstore.dto.ProductsDto;
import com.example.clothingstore.entity.Orders;
import com.example.clothingstore.entity.Products;
import com.example.clothingstore.entity.Users;
import com.example.clothingstore.exception.NotFoundException;
import com.example.clothingstore.exception.ProductNotFoundException;
import com.example.clothingstore.service.ProductsService;
import com.example.clothingstore.utils.EntityDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productRepository;

    @Override
    public List<ProductsDto> getAllProducts() {
        List<Products> products = productRepository.findAll();
        return products.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public ProductsDto saveProduct(ProductsDto productDto) {
        Products products = EntityDtoConverter.toEntity(productDto);
        Products savedProducts = productRepository.save(products);
        return EntityDtoConverter.toDto(savedProducts);
    }

    @Override
    public ProductsDto getProductById(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        return EntityDtoConverter.toDto(product);
    }


    @Override
    public ProductsDto updateProduct(ProductsDto productDto, Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id " + id));
        product.setName(productDto.getName());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setUnitsInStock(productDto.getUnitsInStock());

        Products updatedProduct = productRepository.save(product);

        return EntityDtoConverter.toDto(updatedProduct);
    }


    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        productRepository.deleteById(id);
    }
}

