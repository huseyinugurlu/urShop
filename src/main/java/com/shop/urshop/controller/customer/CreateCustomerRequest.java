package com.shop.urshop.controller.customer;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateCustomerRequest(
    String userName,
    String email,
    String password,
    LocalDateTime creationDate,
    int customerNumber,
    Set<Integer> orderIds,
    Set<Integer> paymentCardIds) {}
