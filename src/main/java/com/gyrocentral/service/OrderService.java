package com.gyrocentral.service;

import com.gyrocentral.model.Order;
import com.gyrocentral.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    CartRepository cartRepository = new CartRepository();

    public Map<String, Order> getOrders() {
        return cartRepository.getOrders();
    }

    public Order getOrderById(String id) {
        return getOrders().get(id);
    }

    public Order addOrder() {
        return cartRepository.addOrder();
    }

    public Order updateOrder(String id, Order order) {
        return cartRepository.updateOrder(id, order);
    }

    public Order deleteOrder(String id) {
        return cartRepository.deleteOrder(id);
    }
}
