package com.shop.urshop.controller.customer;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.customer.CustomerService;
import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.paymentCard.PaymentCardService;
import com.shop.urshop.security.Authority;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.CUSTOMER)
public class CustomerController {
  private final CustomerService customerService;

  private final PaymentCardService paymentCardService;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public CustomerController(
      CustomerService customerService,
      PaymentCardService paymentCardService,
      PasswordEncoder passwordEncoder) {
    this.customerService = customerService;
    this.paymentCardService = paymentCardService;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllCustomerResponse> getAll() {
    return GetAllCustomerResponse.fromCustomers(customerService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdCustomerResponse getByIdCustomerResponse(@PathVariable int id) {
    return GetByIdCustomerResponse.fromCustomer(customerService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreateCustomerRequest createCustomerRequest) {
    final Customer customer =
        Customer.builder()
            .name(createCustomerRequest.userName())
            .email(createCustomerRequest.email())
            .phoneNumber(createCustomerRequest.customerNumber())
            .password(passwordEncoder.encode(createCustomerRequest.password()))
            .creationDate(String.valueOf(LocalDate.now()))
            .paymentCard(
                createCustomerRequest.paymentCardIds().stream()
                    .map(paymentCardIs -> PaymentCard.builder().id(paymentCardIs).build())
                    .collect(Collectors.toSet()))
            .authority(Authority.ROLE_CUSTOMER.getAuthority())
            .build();
    this.customerService.add(customer);
  }

  @PutMapping(ApiConstants.UPDATE+ApiConstants.BY_ID)
  public void update(@PathVariable int id,@RequestBody final UpdateCustomerRequest updateCustomerRequest) {
    Customer customer =
        Customer.builder()
                .id(id)
            .name(updateCustomerRequest.userName())
            .email(updateCustomerRequest.email())
            .phoneNumber(updateCustomerRequest.phoneNumber())
            .paymentCard(
                updateCustomerRequest.paymentCardIds().stream()
                    .map(paymentCardIs -> PaymentCard.builder().id(paymentCardIs).build())
                    .collect(Collectors.toSet()))
            .build();
    this.customerService.update(customer);
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.customerService.delete(id);
  }
}
