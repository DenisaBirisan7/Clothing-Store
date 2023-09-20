package com.example.clothingstore.dto;

import com.example.clothingstore.entity.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class OrdersDto {

    private Long id;
    private BigDecimal unitPrice;
    private int totalQuantity;
    private String billingAddress;
    private Status status;
    private List<OrderItemsDto> orderItemsDto;


    public OrdersDto(BigDecimal unitPrice, int totalQuantity, String billingAddress, Status status) {
        this.unitPrice = unitPrice;
        this.totalQuantity = totalQuantity;
        this.billingAddress = billingAddress;
        this.status = status;
    }
}
