package com.shop.urshop.cashier;

import com.shop.urshop.entity.Cashier;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierManager implements CashierService {
  private final CashierRepository cashierRepository;

  @Autowired
  public CashierManager(CashierRepository cashierRepository) {
    this.cashierRepository = cashierRepository;
  }

  @Override
  public List<Cashier> getAll() {
    return cashierRepository.findAll();
  }

  @Override
  public Cashier getByCashierNumber(long cashierNumber) {
    return cashierRepository.findByPhoneNumber(cashierNumber);
  }

  @Override
  public Cashier getById(int id) {
    return cashierRepository
        .findById(id)
        .orElseThrow(() -> new BusinessException("Customer not found!"));
  }

  @Override
  public void add(Cashier cashier) {
    this.cashierRepository.save(cashier);
  }

  @Override
  public void update(Cashier cashier) {
    this.cashierRepository.save(cashier);
  }

  @Override
  public void delete(int id) {
    getByCashierNumber(id);
    this.cashierRepository.deleteById(id);
  }
}
