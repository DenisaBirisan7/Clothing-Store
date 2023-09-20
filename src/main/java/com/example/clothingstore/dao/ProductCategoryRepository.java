package com.example.clothingstore.dao;

import com.example.clothingstore.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
}
