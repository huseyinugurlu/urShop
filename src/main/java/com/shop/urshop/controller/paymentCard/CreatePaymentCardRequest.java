package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.entity.Customer;
import java.time.LocalDate;

public record CreatePaymentCardRequest(
    long cardNumber,
    String cardHolderName,
    LocalDate expirationDate,
    int cvv,
    Customer customer) {}
