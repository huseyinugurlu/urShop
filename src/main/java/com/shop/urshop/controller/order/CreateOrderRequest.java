package com.shop.urshop.controller.order;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.OrderItem;
import java.util.Date;
import java.util.Set;

public record CreateOrderRequest(
    float totalAmount, Date orderDate, Customer customer, Set<OrderItem> orderItem) {}
