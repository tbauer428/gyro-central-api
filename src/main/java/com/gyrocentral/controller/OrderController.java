package com.gyrocentral.controller;


import com.gyrocentral.model.Order;
import com.gyrocentral.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class OrderController {
    private OrderService orderService = new OrderService();


    @GetMapping("/orders/all")
    public Map<String, Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById (@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders/add")
    public Order addOrder(){
        return orderService.addOrder();
    }

    @PutMapping("/orders/update/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("orders/delete/{id}")
    public Order deleteOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }

}
