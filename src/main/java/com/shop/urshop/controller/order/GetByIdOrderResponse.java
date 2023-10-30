package com.shop.urshop.controller.order;

import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.OrderItem;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record GetByIdOrderResponse(
    int id, float totalAmount, LocalDate orderDate, Integer customerId, Set<Integer> orderItemIds) {
  public static GetByIdOrderResponse fromOrder(Order order) {
    return new GetByIdOrderResponse(
        order.getId(),
        order.getTotalAmount(),
        order.getOrderDate(),
        order.getCustomer().getId(),
        order.getOrderItem().stream().map(OrderItem::getId).collect(Collectors.toSet()));
  }
}
