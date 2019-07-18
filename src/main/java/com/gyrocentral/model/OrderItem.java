package com.gyrocentral.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderItem {
    private String id;
    private String name;
    private Integer quantity;
    private String description;
    private BigDecimal price;

}
