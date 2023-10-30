package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import java.time.LocalDate;

public record GetByIdPaymentCardResponse(
    int id,
    long cardNumber,
    String cardHolderName,
    LocalDate expirationDate,
    int cvv,
    Integer customerId) {
  public static GetByIdPaymentCardResponse fromPaymentCard(PaymentCard paymentCard) {
    return new GetByIdPaymentCardResponse(
        paymentCard.getId(),
        paymentCard.getCardNumber(),
        paymentCard.getCardHolderName(),
        paymentCard.getExpirationDate(),
        paymentCard.getCvv(),
        paymentCard.getCustomer().getId());
  }
}
