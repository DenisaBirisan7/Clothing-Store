package com.example.clothingstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name="status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItems> orderItems;
}
