package com.shop.urshop.controller.productCustomerOfferMap;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.controller.order.GetAllOrderResponse;
import com.shop.urshop.controller.order.GetByIdOrderResponse;
import com.shop.urshop.productCustomerOfferMap.ProductCustomerOfferMapService;
import com.shop.urshop.productFeatureValueMap.ProductFeatureValueMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productcustomeroffermaps")
public class ProductCustomerOfferMapController extends BaseController {

  private final ProductCustomerOfferMapService productCustomerOfferMapService;

  @Autowired
  public ProductCustomerOfferMapController(
      ProductCustomerOfferMapService productCustomerOfferMapService) {
    this.productCustomerOfferMapService = productCustomerOfferMapService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<?> getAll() {
    final List<GetProductCustomerOfferMap> data =
        GetProductCustomerOfferMap.fromProductCustomerOfferMaps(
            productCustomerOfferMapService.getAll());
    return success(data);
  }

  @GetMapping("/byProductsId/{id}")
  public ResponseEntity<?> getByIdOfferResponse(@PathVariable int id) {
    final List<GetProductCustomerOfferMap> data =
        GetProductCustomerOfferMap.fromProductCustomerOfferMaps(
            productCustomerOfferMapService.getMapsByProductId(id));
    return success(data);
  }
}
