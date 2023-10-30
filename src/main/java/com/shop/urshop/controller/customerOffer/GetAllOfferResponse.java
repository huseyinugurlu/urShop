package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record GetAllOfferResponse(
    int id, float totalAmount, Set<Integer> productCustomerOfferMapIds) {
  public static List<GetAllOfferResponse> fromOffers(List<CustomerOffer> customerOffers) {
    return customerOffers.stream().map(GetAllOfferResponse::fromOffer).toList();
  }

  public static GetAllOfferResponse fromOffer(CustomerOffer customerOffer) {
    return new GetAllOfferResponse(
        customerOffer.getId(),
        customerOffer.getTotalAmount(),
        customerOffer.getProductCustomerOfferMaps().stream()
            .map(ProductCustomerOfferMap::getId)
            .collect(Collectors.toSet()));
  }
}
