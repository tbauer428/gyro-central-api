package com.gyrocentral.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItem {
    private String id;
    private String name;
    private Integer quantity;
    private String description;
    private BigDecimal price;

    public OrderItem(){
        this.id = UUID.randomUUID().toString();
    }

}
