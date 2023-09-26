package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;
import java.util.List;
import java.util.Set;

public record GetAllOfferResponse(float totalAmount, Set<Product> products) {
    public static List<GetAllOfferResponse> fromOffers(List<CustomerOffer> customerOffers){
        return customerOffers.stream().map(GetAllOfferResponse::fromOffer).toList();
    }
    public static GetAllOfferResponse fromOffer(CustomerOffer customerOffer){
        return new GetAllOfferResponse(customerOffer.getTotalAmount(), customerOffer.getProducts());
    }
}
