package com.shop.urshop.controller.order;

import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.OrderItem;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record GetAllOrderResponse(
    int id, float totalAmount, LocalDate orderDate, Integer customerId, Set<Integer> orderItemIds) {
  public static List<GetAllOrderResponse> fromOrders(List<Order> orders) {
    return orders.stream().map(GetAllOrderResponse::fromOrder).toList();
  }

  public static GetAllOrderResponse fromOrder(Order order) {
    return new GetAllOrderResponse(
        order.getId(),
        order.getTotalAmount(),
        order.getOrderDate(),
        order.getCustomer().getId(),
        order.getOrderItem().stream().map(OrderItem::getId).collect(Collectors.toSet()));
  }
}
