package com.shop.urshop.controller.order;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.OrderItem;

import java.time.LocalDate;
import java.util.Set;

public record GetByIdOrderResponse(
    float totalAmount, LocalDate orderDate, Customer customer, Set<OrderItem> orderItem) {
    public static GetByIdOrderResponse fromOrder(Order order){
        return new GetByIdOrderResponse(order.getTotalAmount(), order.getOrderDate(),order.getCustomer(),order.getOrderItem());
    }
}
