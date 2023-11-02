package com.shop.urshop.controller.customer;

import java.util.Set;

public record CreateCustomerRequest(
    String userName,
    String email,
    String password,
    int customerNumber,
    Set<Integer> paymentCardIds) {}
