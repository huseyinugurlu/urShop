package com.shop.urshop.cashier;

import com.shop.urshop.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository extends JpaRepository<Cashier, Integer> {
  Cashier findByPhoneNumber(long cashierNumber);
}
