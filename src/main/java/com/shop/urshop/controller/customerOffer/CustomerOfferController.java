package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.customerOffer.CustomerOfferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.CUSTOMER_OFFER)
public class CustomerOfferController {
  private final CustomerOfferService customerOfferService;

  @Autowired
  public CustomerOfferController(CustomerOfferService customerOfferService) {
    this.customerOfferService = customerOfferService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllOfferResponse> getAll() {
    return GetAllOfferResponse.fromOffers(customerOfferService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdOfferResponse getByIdCustomerOfferResponse(@PathVariable int id) {
    return GetByIdOfferResponse.fromOffer(customerOfferService.getById(id));
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.customerOfferService.delete(id);
  }
}
