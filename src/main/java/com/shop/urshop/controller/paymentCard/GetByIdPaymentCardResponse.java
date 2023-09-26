package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.PaymentCard;
import java.time.LocalDate;

public record GetByIdPaymentCardResponse(
    long cardNumber, String cardHolderName, LocalDate expirationDate, int cvv, Customer customer) {
  public static GetByIdPaymentCardResponse fromPaymentCard(PaymentCard paymentCard) {
    return new GetByIdPaymentCardResponse(
        paymentCard.getCardNumber(),
        paymentCard.getCardHolderName(),
        paymentCard.getExpirationDate(),
        paymentCard.getCvv(),
        paymentCard.getCustomer());
  }
}
