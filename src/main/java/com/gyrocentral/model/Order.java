package com.gyrocentral.model;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String id;
    private String deliveryAddress;
    private List<OrderItem> orderItems;


    public Order(){
        this.id = UUID.randomUUID().toString();
    }



}
