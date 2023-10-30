package com.shop.urshop.controller.paymentCard;


import java.time.LocalDate;

public record UpdatePaymentCardRequest(
    long cardNumber,
    String cardHolderName,
    LocalDate expirationDate,
    int cvv,
    Integer customerId) {}
