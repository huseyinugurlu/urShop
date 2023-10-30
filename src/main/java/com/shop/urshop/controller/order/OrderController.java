package com.shop.urshop.controller.order;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.order.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.ORDERS)
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllOrderResponse> getAll() {
    return GetAllOrderResponse.fromOrders(orderService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdOrderResponse getByIdOrderResponse(@PathVariable int id) {
    return GetByIdOrderResponse.fromOrder(orderService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreateOrderRequest createOrderRequest) {
    this.orderService.add(
        createOrderRequest.totalAmount(),
        createOrderRequest.orderDate(),
        createOrderRequest.customerId(),
        createOrderRequest.orderItemIds());
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.orderService.delete(id);
  }
}
