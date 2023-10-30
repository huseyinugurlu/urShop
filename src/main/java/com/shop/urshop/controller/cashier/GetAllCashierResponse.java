package com.shop.urshop.controller.cashier;

import com.shop.urshop.entity.Cashier;
import java.util.List;

public record GetAllCashierResponse(
    int id, String userName, String email, String creationDate, long cashierNumber) {

  public static List<GetAllCashierResponse> fromCashiers(List<Cashier> cashiers) {
    return cashiers.stream().map(GetAllCashierResponse::fromCashier).toList();
  }

  public static GetAllCashierResponse fromCashier(Cashier cashier) {
    return new GetAllCashierResponse(
        cashier.getId(),
        cashier.getName(),
        cashier.getEmail(),
        cashier.getCreationDate(),
        cashier.getPhoneNumber());
  }
}
