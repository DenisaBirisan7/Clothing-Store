package com.example.clothingstore.controller;

import com.example.clothingstore.dto.ProductCategoryDto;
import com.example.clothingstore.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/product_category")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/addProductCategory")
    public ResponseEntity<ProductCategoryDto> saveProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
        ProductCategoryDto savedProductCategory = productCategoryService.saveProductCategory(productCategoryDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Product category created successfully.")
                .body(savedProductCategory);
    }


    @GetMapping("/allProductCategory")
    public ResponseEntity<List<ProductCategoryDto>> getAllProductCategory() {
        return new ResponseEntity<>(productCategoryService.getAllProductCategory(), HttpStatus.OK);
    }

    @GetMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryDto> getProductCategoryById(@PathVariable("productCategoryId") Long productCategoryId) {
        ProductCategoryDto productCategoryById = productCategoryService.getProductCategoryById(productCategoryId);

        return new ResponseEntity<>(productCategoryById, HttpStatus.OK);
    }

    @PutMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryDto> updateProductCategory(@PathVariable("productCategoryId") Long productCategoryId,
                                                     @RequestBody ProductCategoryDto productCategoryDto) {
        ProductCategoryDto updatedProductCategory = productCategoryService.updateProductCategory(productCategoryDto, productCategoryId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Product category updated successfully.")
                .body(updatedProductCategory);
    }

    @DeleteMapping("/{productCategoryId}")
    public ResponseEntity<String> deleteProductCategoryById(@PathVariable("productCategoryId") Long productCategoryId) {
        productCategoryService.deleteProductCategoryById(productCategoryId);

        return ResponseEntity.ok("Product category was deleted successfully!");
    }
}
