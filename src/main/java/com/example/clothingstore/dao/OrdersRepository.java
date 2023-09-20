package com.example.clothingstore.dao;

import com.example.clothingstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Orders, Long>{



}
