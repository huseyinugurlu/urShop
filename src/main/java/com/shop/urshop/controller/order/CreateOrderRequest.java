package com.shop.urshop.controller.order;

import java.util.Date;
import java.util.Set;

public record CreateOrderRequest(
    float totalAmount, Date orderDate, Integer customerId, Set<Integer> orderItemIds) {}
