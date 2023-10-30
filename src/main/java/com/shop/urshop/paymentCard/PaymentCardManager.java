package com.shop.urshop.paymentCard;

import com.shop.urshop.customer.CustomerService;
import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.exception.BusinessException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardManager implements PaymentCardService {

  private final PaymentCardRepository paymentCardRepository;

  private final CustomerService customerService;

  @Autowired
  public PaymentCardManager(
      PaymentCardRepository paymentCardRepository, CustomerService customerService) {
    this.paymentCardRepository = paymentCardRepository;
    this.customerService = customerService;
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
  public void add(
      long cardNumber,
      String cardHolderName,
      LocalDate expirationDate,
      int cvv,
      Integer customerId) {
    final PaymentCard paymentCard =
        PaymentCard.builder()
            .cardNumber(cardNumber)
            .cardHolderName(cardHolderName)
            .cvv(cvv)
            .expirationDate(expirationDate)
            .customer(customerService.getById(customerId))
            .build();
    this.paymentCardRepository.save(paymentCard);
  }

  @Override
  public void update(
      int id,
      long cardNumber,
      String cardHolderName,
      LocalDate expirationDate,
      int cvv,
      Integer customerId) {

    final PaymentCard paymentCard = getById(id);
    paymentCard.setCardNumber(cardNumber);
    paymentCard.setCardHolderName(cardHolderName);
    paymentCard.setExpirationDate(expirationDate);
    paymentCard.setCvv(cvv);
    paymentCard.setCustomer(customerService.getById(customerId));
    this.paymentCardRepository.save(paymentCard);
  }

  @Override
  public void delete(int paymentCardId) {
    getById(paymentCardId);
    this.paymentCardRepository.deleteById(paymentCardId);
  }
}
