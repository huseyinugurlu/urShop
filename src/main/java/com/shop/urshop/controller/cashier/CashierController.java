package com.shop.urshop.controller.cashier;

import com.shop.urshop.cashier.CashierService;
import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.entity.Cashier;
import com.shop.urshop.security.Authority;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.CASHIER)
public class CashierController {
  private final CashierService cashierService;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public CashierController(CashierService cashierService, PasswordEncoder passwordEncoder) {
    this.cashierService = cashierService;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllCashierResponse> getAll() {
    return GetAllCashierResponse.fromCashiers(cashierService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdCashierResponse getByIdCashierResponse(@PathVariable int id) {
    return GetByIdCashierResponse.fromCustomer(cashierService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreateCashierRequest createCashierRequest) {
    final Cashier cashier =
        Cashier.builder()
            .name(createCashierRequest.userName())
            .email(createCashierRequest.email())
            .password(passwordEncoder.encode(createCashierRequest.password()))
            .creationDate(String.valueOf(LocalDate.now()))
            .phoneNumber(createCashierRequest.cashierNumber())
            .authority(Authority.ROLE_CASHIER.getAuthority())
            .build();
    this.cashierService.add(cashier);
  }

  @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
  public void update(
      @PathVariable int id, @RequestBody final UpdateCashierRequest updateCashierRequest) {
    Cashier cashier =
        Cashier.builder()
            .id(id)
            .name(updateCashierRequest.userName())
            .email(updateCashierRequest.email())
            .phoneNumber(updateCashierRequest.phoneNumber())
            .build();
    this.cashierService.update(cashier);
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.cashierService.delete(id);
  }
}
