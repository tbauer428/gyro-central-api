package com.gyrocentral.controller;


import com.gyrocentral.model.Order;
import com.gyrocentral.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path="/orders")
public class OrderController {
    private OrderService orderService = new OrderService();

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Order getOrderById (@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addOrder(){
        return orderService.addOrder();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable String id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Order deleteOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }

}
