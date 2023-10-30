package com.shop.urshop.controller.customer;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.PaymentCard;
import java.util.Set;
import java.util.stream.Collectors;

public record GetByIdCustomerResponse(
    int id,
    String userName,
    String email,
    String creationDate,
    int customerNumber,
    Set<Integer> orderIds,
    Set<Integer> paymentCardIds) {

  public static GetByIdCustomerResponse fromCustomer(Customer customer) {
    return new GetByIdCustomerResponse(
        customer.getId(),
        customer.getName(),
        customer.getEmail(),
        customer.getCreationDate(),
        customer.getPhoneNumber(),
        customer.getOrder().stream().map(Order::getId).collect(Collectors.toSet()),
        customer.getPaymentCard().stream().map(PaymentCard::getId).collect(Collectors.toSet()));
  }
}
