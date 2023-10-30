package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.paymentCard.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.PAYMENT_CARDS)
public class PaymentCardController {

  private final PaymentCardService paymentCardService;

  @Autowired
  public PaymentCardController(PaymentCardService paymentCardService) {
    this.paymentCardService = paymentCardService;
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
        createPaymentCardRequest.cardNumber(),
        createPaymentCardRequest.cardHolderName(),
        createPaymentCardRequest.expirationDate(),
        createPaymentCardRequest.cvv(),
        createPaymentCardRequest.customerId());
  }

  @PutMapping(ApiConstants.ADD)
  public void update(
      @PathVariable int id, @RequestBody final UpdatePaymentCardRequest updatePaymentCardRequest) {

    this.paymentCardService.update(
        id,
        updatePaymentCardRequest.cardNumber(),
        updatePaymentCardRequest.cardHolderName(),
        updatePaymentCardRequest.expirationDate(),
        updatePaymentCardRequest.cvv(),
        updatePaymentCardRequest.customerId());
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.paymentCardService.delete(id);
  }
}
