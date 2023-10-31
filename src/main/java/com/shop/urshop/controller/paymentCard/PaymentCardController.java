package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.customer.CustomerService;
import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.paymentCard.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.PAYMENT_CARDS)
public class PaymentCardController {

  private final PaymentCardService paymentCardService;
  private final CustomerService customerService;

  @Autowired
  public PaymentCardController(
      PaymentCardService paymentCardService,@Lazy CustomerService customerService) {
    this.paymentCardService = paymentCardService;
    this.customerService = customerService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllPaymentCardResponse> getAll() {
    return GetAllPaymentCardResponse.fromPaymentCards(paymentCardService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdPaymentCardResponse getByIdPaymentCardResponse(@PathVariable int id) {
    return GetByIdPaymentCardResponse.fromPaymentCard(paymentCardService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreatePaymentCardRequest createPaymentCardRequest) {
    this.paymentCardService.add(
        PaymentCard.builder()
            .cardHolderName(createPaymentCardRequest.cardHolderName())
            .cvv(createPaymentCardRequest.cvv())
            .expirationDate(createPaymentCardRequest.expirationDate())
            .cardNumber(createPaymentCardRequest.cardNumber())
            .customer(customerService.getById(createPaymentCardRequest.customerId()))
            .build());
  }

  @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
  public void update(
      @PathVariable int id, @RequestBody final UpdatePaymentCardRequest updatePaymentCardRequest) {
    this.paymentCardService.update(
        PaymentCard.builder()
            .id(id)
            .cardHolderName(updatePaymentCardRequest.cardHolderName())
            .cvv(updatePaymentCardRequest.cvv())
            .expirationDate(updatePaymentCardRequest.expirationDate())
            .cardNumber(updatePaymentCardRequest.cardNumber())
            .build());
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.paymentCardService.delete(id);
  }
}
