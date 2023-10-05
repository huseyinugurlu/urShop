package com.shop.urshop.controller.productCustomerOfferMap;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.List;

public record GetProductCustomerOfferMap(Product product, CustomerOffer customerOffer) {

    public static List<GetProductCustomerOfferMap> fromProductCustomerOfferMaps(List<ProductCustomerOfferMap> productCustomerOfferMaps){
        return productCustomerOfferMaps.stream().map(GetProductCustomerOfferMap::fromProductCustomerOfferMap).toList();
    }
    public static GetProductCustomerOfferMap fromProductCustomerOfferMap(ProductCustomerOfferMap productCustomerOfferMap){
        return new GetProductCustomerOfferMap(productCustomerOfferMap.getProduct(),productCustomerOfferMap.getCustomerOffer());
    }
}
