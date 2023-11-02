package com.shop.urshop.order;

import com.shop.urshop.customer.CustomerService;
import com.shop.urshop.entity.Order;
import com.shop.urshop.exception.BusinessException;
import com.shop.urshop.orderItem.OrderItemService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements OrderService {

  private final OrderRepository orderRepository;

  private final CustomerService customerService;

  private final OrderItemService orderItemService;

  @Autowired
  public OrderManager(
      OrderRepository orderRepository,
      CustomerService customerService,
      OrderItemService orderItemService) {
    this.orderRepository = orderRepository;
    this.customerService = customerService;
    this.orderItemService = orderItemService;
  }

  @Override
  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  @Override
  public Order getById(int orderId) {
    return orderRepository
        .findById(orderId)
        .orElseThrow(() -> new BusinessException("Order not found!"));
  }

  @Override
  public void add(
      float totalAmount, Date orderDate, Integer customerId, Set<Integer> orderItemIds) {
    Order order =
        Order.builder()
            .totalAmount(totalAmount)
            .orderDate(LocalDate.now())
            .customer(customerService.getById(customerId))
            .orderItem(
                orderItemIds.stream().map(orderItemService::getById).collect(Collectors.toSet()))
            .build();
    this.orderRepository.save(order);
  }

  @Override
  public void delete(int orderId) {
    getById(orderId);
    this.orderRepository.deleteById(orderId);
  }
}
