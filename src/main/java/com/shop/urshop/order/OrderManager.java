package com.shop.urshop.order;


import com.shop.urshop.entity.Order;
import com.shop.urshop.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int orderId) {
        return  orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException("Order not found!"));
    }

    @Override
    public void add(Order order) {
        this.orderRepository.save(order);
    }


    @Override
    public void delete(int orderId) {
        if (orderRepository.existsById(orderId)) {
            this.orderRepository.deleteById(orderId);
        }else{
            throw new BusinessException("Order not found!");
        }

    }
}
