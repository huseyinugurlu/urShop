package com.shop.urshop.orderItem;

import com.shop.urshop.entity.OrderItem;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemManager implements OrderItemService {
  private final OrderItemRepository orderItemRepository;

  @Autowired
  public OrderItemManager(OrderItemRepository orderItemRepository) {
    this.orderItemRepository = orderItemRepository;
  }

  @Override
  public List<OrderItem> getAll() {
    return orderItemRepository.findAll();
  }

  @Override
  public OrderItem getById(int orderItemId) {
    return orderItemRepository
        .findById(orderItemId)
        .orElseThrow(() -> new BusinessException("Order not found!"));
  }
}
