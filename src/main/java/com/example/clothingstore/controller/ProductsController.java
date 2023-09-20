package com.example.clothingstore.controller;

import com.example.clothingstore.dto.ProductsDto;
import com.example.clothingstore.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping("/add")
    public ResponseEntity<ProductsDto> saveProduct(@RequestBody ProductsDto productDto) {
        ProductsDto savedProduct = productsService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Product created successfully.")
                .body(savedProduct);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductsDto>> getAllProducts() {
        return new ResponseEntity<>(productsService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable("productId") Long productId) {
        ProductsDto productById = productsService.getProductById(productId);

        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable("productId") Long productId,
                                                     @RequestBody ProductsDto productDto) {
        ProductsDto updatedProduct = productsService.updateProduct(productDto, productId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Product updated successfully.")
                .body(updatedProduct);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Long productId) {
        productsService.deleteProductById(productId);

        return ResponseEntity.ok("Product was deleted successfully!");
    }
}






