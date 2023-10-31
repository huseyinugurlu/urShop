package com.shop.urshop.controller.customer;

import java.time.LocalDateTime;
import java.util.Set;

public record UpdateCustomerRequest(
    String userName,
    String email,
    int customerNumber,
    Set<Integer> paymentCardIds) {}
