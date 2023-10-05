package com.shop.urshop.controller.productFeatureValueMap;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.controller.productCustomerOfferMap.GetProductCustomerOfferMap;
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
@RequestMapping("/api/productfeaturevaluemaps")
public class ProductFeatureValueMapController extends BaseController {

  private final ProductFeatureValueMapService productFeatureValueMapService;

  @Autowired
  public ProductFeatureValueMapController(
          ProductFeatureValueMapService productFeatureValueMapService) {
    this.productFeatureValueMapService = productFeatureValueMapService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<?> getAll() {
    final List<GetProductFeatureValueMap> data =
            GetProductFeatureValueMap.fromProductFeatureValueMaps(
                    productFeatureValueMapService.getAll());
    return success(data);
  }

  @GetMapping("/getByFeature/{id}")
  public ResponseEntity<?> getByFeatureIdMapResponse(@PathVariable int id) {
    final List<GetProductFeatureValueMap> data =
            GetProductFeatureValueMap.fromProductFeatureValueMaps(productFeatureValueMapService.getMapsByFeatureId(id));
    return success(data);
  }
  @GetMapping("/getByProduct/{id}")
  public ResponseEntity<?> getByProductIdMapResponse(@PathVariable int id) {
    final List<GetProductFeatureValueMap> data =
            GetProductFeatureValueMap.fromProductFeatureValueMaps(productFeatureValueMapService.getMapsByProductId(id));
    return success(data);
  }
}
