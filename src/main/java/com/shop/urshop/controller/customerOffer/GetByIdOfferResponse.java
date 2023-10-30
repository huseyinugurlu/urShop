package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.Set;
import java.util.stream.Collectors;

public record GetByIdOfferResponse(
    int id, float totalAmount, Set<Integer> productCustomerOfferMapIds) {
  public static GetByIdOfferResponse fromOffer(CustomerOffer customerOffer) {
    return new GetByIdOfferResponse(
        customerOffer.getId(),
        customerOffer.getTotalAmount(),
        customerOffer.getProductCustomerOfferMaps().stream()
            .map(ProductCustomerOfferMap::getId)
            .collect(Collectors.toSet()));
  }
}
