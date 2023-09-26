package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record UpdatePaymentCardRequest(
        int id,
        long cardNumber,
        String cardHolderName,
        LocalDate expirationDate,
        int cvv,
        Customer customer)  {}