package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.PaymentCard;
import java.time.LocalDate;
import java.util.List;

public record GetAllPaymentCardResponse(
    long cardNumber, String cardHolderName, LocalDate expirationDate, int cvv, Customer customer) {
  public static List<GetAllPaymentCardResponse> fromPaymentCards(List<PaymentCard> paymentCards) {
    return paymentCards.stream().map(GetAllPaymentCardResponse::fromPaymentCard).toList();
  }

  public static GetAllPaymentCardResponse fromPaymentCard(PaymentCard paymentCard) {
    return new GetAllPaymentCardResponse(
        paymentCard.getCardNumber(),
        paymentCard.getCardHolderName(),
        paymentCard.getExpirationDate(),
        paymentCard.getCvv(),
        paymentCard.getCustomer());
  }
}
