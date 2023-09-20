package com.example.clothingstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItems> orderItems;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;


}
