package com.example.clothingstore.dao;

import com.example.clothingstore.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemsRepository extends JpaRepository<OrderItems, Long>{


    }


