package com.shop.urshop.controller.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;

import java.util.Set;

public record GetByIdOfferResponse (float totalAmount, Set<Product> products) {
    public static GetByIdOfferResponse fromOffer(CustomerOffer customerOffer){
        return new GetByIdOfferResponse(customerOffer.getTotalAmount(), null);
    }
}
