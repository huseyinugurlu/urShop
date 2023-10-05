package com.shop.urshop.controller.customer;

import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.PaymentCard;

import java.time.LocalDateTime;
import java.util.Set;

public record UpdateCustomerRequest (
        String userName,
        String email,
        LocalDateTime creationDate,
        int customerNumber,
        Set<Order> order,
        Set<PaymentCard> paymentCard){}
