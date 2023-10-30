package com.shop.urshop.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import java.time.LocalDate;
import java.util.List;

public interface PaymentCardService {
  List<PaymentCard> getAll();

  PaymentCard getById(int categoryId);

  void add(
      long cardNumber,
      String cardHolderName,
      LocalDate expirationDate,
      int cvv,
      Integer customerId);

  void update(
      int id,
      long cardNumber,
      String cardHolderName,
      LocalDate expirationDate,
      int cvv,
      Integer customerId);

  void delete(int paymentCardId);
}
