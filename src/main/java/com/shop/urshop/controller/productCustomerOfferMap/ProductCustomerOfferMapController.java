package com.shop.urshop.controller.productCustomerOfferMap;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.productCustomerOfferMap.ProductCustomerOfferMapService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.PRODUCT_CUSTOMER_OFFER_MAP)
public class ProductCustomerOfferMapController {

  private final ProductCustomerOfferMapService productCustomerOfferMapService;

  @Autowired
  public ProductCustomerOfferMapController(
      ProductCustomerOfferMapService productCustomerOfferMapService) {
    this.productCustomerOfferMapService = productCustomerOfferMapService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetProductCustomerOfferMap> getAll() {
    return GetProductCustomerOfferMap.fromProductCustomerOfferMaps(
        productCustomerOfferMapService.getAll());
  }

  @GetMapping(ApiConstants.GET_BY_PRODUCT_ID + ApiConstants.BY_ID)
  public List<GetProductCustomerOfferMap> getByIdOfferResponse(@PathVariable int id) {
    return GetProductCustomerOfferMap.fromProductCustomerOfferMaps(
        productCustomerOfferMapService.getMapsByProductId(id));
  }
}
