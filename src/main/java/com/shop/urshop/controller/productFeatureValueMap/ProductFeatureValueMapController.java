package com.shop.urshop.controller.productFeatureValueMap;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.productFeatureValueMap.ProductFeatureValueMapService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.PRODUCT_FEATURE_VALUE_MAP)
public class ProductFeatureValueMapController {

  private final ProductFeatureValueMapService productFeatureValueMapService;

  @Autowired
  public ProductFeatureValueMapController(
      ProductFeatureValueMapService productFeatureValueMapService) {
    this.productFeatureValueMapService = productFeatureValueMapService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetProductFeatureValueMap> getAll() {
    return GetProductFeatureValueMap.fromProductFeatureValueMaps(
        productFeatureValueMapService.getAll());
  }

  @GetMapping(ApiConstants.GET_BY_FEATURE_ID + ApiConstants.BY_ID)
  public List<GetProductFeatureValueMap> getByFeatureIdMapResponse(@PathVariable int id) {
    return GetProductFeatureValueMap.fromProductFeatureValueMaps(
        productFeatureValueMapService.getMapsByFeatureId(id));
  }

  @GetMapping(ApiConstants.GET_BY_PRODUCT_ID + ApiConstants.BY_ID)
  public List<GetProductFeatureValueMap> getByProductIdMapResponse(@PathVariable int id) {
    return GetProductFeatureValueMap.fromProductFeatureValueMaps(
        productFeatureValueMapService.getMapsByProductId(id));
  }
}
