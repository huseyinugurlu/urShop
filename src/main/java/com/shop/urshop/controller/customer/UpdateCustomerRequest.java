package com.shop.urshop.controller.customer;

import java.util.Set;

public record UpdateCustomerRequest(
    String userName, String email, int phoneNumber, Set<Integer> paymentCardIds) {}
