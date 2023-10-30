package com.shop.urshop.controller.cashier;

import com.shop.urshop.entity.Cashier;

public record GetByIdCashierResponse(
    int id, String userName, String email, String creationDate, long cashierNumber) {

  public static GetByIdCashierResponse fromCustomer(Cashier cashier) {
    return new GetByIdCashierResponse(
        cashier.getId(),
        cashier.getName(),
        cashier.getEmail(),
        cashier.getCreationDate(),
        cashier.getPhoneNumber());
  }
}
