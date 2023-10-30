package com.shop.urshop.paymentCard;

import com.shop.urshop.entity.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Integer> {}
