package com.shop.urshop.controller.order;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.OrderItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record GetAllOrderResponse(float totalAmount, LocalDate orderDate, Customer customer, Set<OrderItem> orderItem) {
    public static List<GetAllOrderResponse> fromOrders(List<Order> orders){
        return orders.stream().map(GetAllOrderResponse::fromOrder).toList();
    }
    public static GetAllOrderResponse fromOrder(Order order){
        return new GetAllOrderResponse(order.getTotalAmount(), order.getOrderDate(),order.getCustomer(),order.getOrderItem());
    }
}
