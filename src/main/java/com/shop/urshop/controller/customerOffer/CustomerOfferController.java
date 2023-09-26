package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.customerOffer.CustomerOfferService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customerOffers")
public class CustomerOfferController extends BaseController {
    private final CustomerOfferService customerOfferService;

    @Autowired
    public CustomerOfferController(CustomerOfferService customerOfferService) {
        this.customerOfferService = customerOfferService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllOfferResponse> data= GetAllOfferResponse.fromOffers(customerOfferService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdCustomerOfferResponse(@PathVariable int id) {
        final GetByIdOfferResponse data= GetByIdOfferResponse.fromOffer(customerOfferService.getById(id));
        return success(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.customerOfferService.delete(id);
    }


}
