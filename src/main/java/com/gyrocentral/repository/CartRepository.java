package com.gyrocentral.repository;

import com.gyrocentral.model.Order;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Accessors(chain = true)
public class CartRepository {


    private Map<String, Order> orderMap = new HashMap<>();

    public Map<String, Order> getOrders(){
        return orderMap;
    }

    public Order addOrder() {
        Order order = new Order();
        orderMap.put(order.getId(), order);
        return order;
    }

    public Order updateOrder(String id, Order order) {
        orderMap.replace(id, order);
        return order;
    }
}
