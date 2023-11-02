package com.shop.urshop.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import java.util.List;

public interface PaymentCardService {
  List<PaymentCard> getAll();

  PaymentCard getById(int categoryId);

  void add(PaymentCard paymentCard);

  void update(PaymentCard paymentCard);

  void delete(int paymentCardId);
}
