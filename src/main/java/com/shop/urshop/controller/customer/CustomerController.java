package com.shop.urshop.controller.customer;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.customer.CustomerService;
import com.shop.urshop.entity.Customer;

import java.time.LocalDate;
import java.util.List;

import com.shop.urshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController extends BaseController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<?> getAll() {
    final List<GetAllCustomerResponse> data =
        GetAllCustomerResponse.fromCustomers(customerService.getAll());
    return success(data);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getByIdCustomerResponse(@PathVariable long id) {
    final GetByIdCustomerResponse data =
        GetByIdCustomerResponse.fromCustomer(customerService.getByCustomerNumber(id));
    return success(data);
  }

  @PostMapping("/add")
  public void add(@RequestBody CreateCustomerRequest createCustomerRequest) {
    final Customer customer =
        Customer.builder()
            .userName(createCustomerRequest.userName())
            .email(createCustomerRequest.email())
            .password(createCustomerRequest.password())
            .creationDate(String.valueOf(LocalDate.now()))
            .customerNumber(createCustomerRequest.customerNumber())
            .order(createCustomerRequest.order())
            .paymentCard(createCustomerRequest.paymentCard())
            .build();
    this.customerService.add(customer);
  }

  @PutMapping("/update")
  public void update(@RequestBody final UpdateCustomerRequest updateCustomerRequest) {
    Customer customer =
        Customer.builder()
                .userName(updateCustomerRequest.userName())
                .email(updateCustomerRequest.email())
                .creationDate(String.valueOf(LocalDate.now()))
                .customerNumber(updateCustomerRequest.customerNumber())
                .order(updateCustomerRequest.order())
                .paymentCard(updateCustomerRequest.paymentCard())
                .build();
    this.customerService.update(customer);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    this.customerService.delete(id);
  }
}
