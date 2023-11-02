package com.shop.urshop.cashier;

import com.shop.urshop.entity.Cashier;
import java.util.List;

public interface CashierService {
  List<Cashier> getAll();

  Cashier getByCashierNumber(long cashierNumber);

  Cashier getById(int id);

  void add(Cashier cashier);

  void update(Cashier cashier);

  void delete(int id);
}
