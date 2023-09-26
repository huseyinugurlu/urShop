package com.shop.urshop.controller.order;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.entity.Order;
import com.shop.urshop.order.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){this.orderService=orderService;}


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllOrderResponse> data = GetAllOrderResponse.fromOrders(orderService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdOrderResponse(@PathVariable int id) {
        final GetByIdOrderResponse data = GetByIdOrderResponse.fromOrder(orderService.getById(id));
        return success(data);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateOrderRequest createOrderRequest) {
        final Order order = Order.builder()
                .totalAmount(createOrderRequest.totalAmount())
                .orderItem(createOrderRequest.orderItem())
                .customer(createOrderRequest.customer())
                .orderDate(LocalDate.now())
                .build();
        this.orderService.add(order);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.orderService.delete(id);
    }
}
