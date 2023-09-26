package com.shop.urshop.controller.paymentCard;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.entity.PaymentCard;
import com.shop.urshop.paymentCard.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/paymentCards")
public class PaymentCardController extends BaseController {

    private final PaymentCardService paymentCardService;

    @Autowired
    public PaymentCardController(PaymentCardService paymentCardService) {
        this.paymentCardService = paymentCardService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllPaymentCardResponse> data=GetAllPaymentCardResponse.fromPaymentCards(paymentCardService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getByIdPaymentCardResponse(@PathVariable int id) {
        final GetByIdPaymentCardResponse data=GetByIdPaymentCardResponse.fromPaymentCard(paymentCardService.getById(id));
        return success(data);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreatePaymentCardRequest createPaymentCardRequest) {
        final PaymentCard paymentCard= PaymentCard.builder()
                .cardNumber(createPaymentCardRequest.cardNumber())
                .cardHolderName(createPaymentCardRequest.cardHolderName())
                .cvv(createPaymentCardRequest.cvv())
                .expirationDate(createPaymentCardRequest.expirationDate())
                .customer(createPaymentCardRequest.customer())
                .build();
        this.paymentCardService.add(paymentCard);
    }

    @PutMapping("/update")
    public void update(@RequestBody final UpdatePaymentCardRequest updatePaymentCardRequest) {
        PaymentCard paymentCard = PaymentCard.builder()
                .id(updatePaymentCardRequest.id())
                .cardNumber(updatePaymentCardRequest.cardNumber())
                .cardHolderName(updatePaymentCardRequest.cardHolderName())
                .cvv(updatePaymentCardRequest.cvv())
                .expirationDate(updatePaymentCardRequest.expirationDate())
                .customer(updatePaymentCardRequest.customer())
                .build();
        this.paymentCardService.update(paymentCard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.paymentCardService.delete(id);
    }

}
