package com.shop.urshop.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardManager implements PaymentCardService {

  private final PaymentCardRepository paymentCardRepository;

  @Autowired
  public PaymentCardManager(PaymentCardRepository paymentCardRepository) {
    this.paymentCardRepository = paymentCardRepository;
  }

  @Override
  public List<PaymentCard> getAll() {
    return paymentCardRepository.findAll();
  }

  @Override
  public PaymentCard getById(int paymentCardId) {
    return paymentCardRepository
        .findById(paymentCardId)
        .orElseThrow(() -> new BusinessException("Payment Card is not found!"));
  }

  @Override
  public void add(PaymentCard paymentCard) {
    this.paymentCardRepository.save(paymentCard);
  }

  @Override
  public void update(PaymentCard paymentCard) {
    final PaymentCard updatedPaymentCard = getById(paymentCard.getId());
    updatedPaymentCard.setCardNumber(paymentCard.getCardNumber());
    updatedPaymentCard.setCardHolderName(paymentCard.getCardHolderName());
    updatedPaymentCard.setExpirationDate(paymentCard.getExpirationDate());
    updatedPaymentCard.setCvv(paymentCard.getCvv());
    this.paymentCardRepository.save(updatedPaymentCard);
  }

  @Override
  public void delete(int paymentCardId) {
    getById(paymentCardId);
    this.paymentCardRepository.deleteById(paymentCardId);
  }
}
