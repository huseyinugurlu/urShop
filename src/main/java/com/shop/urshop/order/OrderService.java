package com.shop.urshop.order;

import com.shop.urshop.entity.Order;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderService {
  List<Order> getAll();

  Order getById(int orderId);

  void add(float totalAmount, Date orderDate, Integer customerId, Set<Integer> orderItemIds);

  void delete(int orderId);
}
