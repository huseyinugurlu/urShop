package com.shop.urshop.controller.productCustomerOfferMap;

import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.List;

public record GetProductCustomerOfferMap(int id, Integer productId, Integer customerOfferId) {

  public static List<GetProductCustomerOfferMap> fromProductCustomerOfferMaps(
      List<ProductCustomerOfferMap> productCustomerOfferMaps) {
    return productCustomerOfferMaps.stream()
        .map(GetProductCustomerOfferMap::fromProductCustomerOfferMap)
        .toList();
  }

  public static GetProductCustomerOfferMap fromProductCustomerOfferMap(
      ProductCustomerOfferMap productCustomerOfferMap) {
    return new GetProductCustomerOfferMap(
        productCustomerOfferMap.getId(),
        productCustomerOfferMap.getProduct().getId(),
        productCustomerOfferMap.getCustomerOffer().getId());
  }
}
