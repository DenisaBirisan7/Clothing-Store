package com.example.clothingstore.dao;

import com.example.clothingstore.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface ProductsRepository extends JpaRepository<Products, Long>{



}
