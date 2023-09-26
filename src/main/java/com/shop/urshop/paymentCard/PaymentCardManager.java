package com.shop.urshop.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.exception.BusinessException;
import com.shop.urshop.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardManager implements PaymentCardService{

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
        if (paymentCardRepository.existsById(paymentCard.getId())) {
            this.paymentCardRepository.save(paymentCard);
        } else {
      throw new BusinessException("Payment Card not found!");
        }
    }

    @Override
    public void delete(int paymentCardId) {
        if (paymentCardRepository.existsById(paymentCardId)) {
            this.paymentCardRepository.deleteById(paymentCardId);
        }else {
      throw new BusinessException("Payment Card not found!");
        }

    }
}
