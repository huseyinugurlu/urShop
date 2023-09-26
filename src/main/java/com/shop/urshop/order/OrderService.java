package com.shop.urshop.order;

import com.shop.urshop.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getById(int orderId);

    void add(Order order);

    void delete(int orderId);
}
