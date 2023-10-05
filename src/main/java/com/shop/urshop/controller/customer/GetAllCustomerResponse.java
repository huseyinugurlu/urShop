package com.shop.urshop.controller.customer;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.PaymentCard;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record GetAllCustomerResponse(
    String userName,
    String email,
    String creationDate,
    int customerNumber,
    Set<Order> order,
    Set<PaymentCard> paymentCard) {

  public static List<GetAllCustomerResponse> fromCustomers(List<Customer> customer) {
    return customer.stream().map(GetAllCustomerResponse::fromCustomer).toList();
  }

  public static GetAllCustomerResponse fromCustomer(Customer customer) {
    return new GetAllCustomerResponse(
        customer.getUserName(),
        customer.getEmail(),
        customer.getCreationDate(),
        customer.getCustomerNumber(),
        customer.getOrder(),
        customer.getPaymentCard());
  }
}
