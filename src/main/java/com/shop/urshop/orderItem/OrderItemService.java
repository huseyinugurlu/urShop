package com.shop.urshop.orderItem;

import com.shop.urshop.entity.OrderItem;
import java.util.List;

public interface OrderItemService {
  List<OrderItem> getAll();

  OrderItem getById(int orderId);
}
