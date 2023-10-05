package com.shop.urshop.controller.productFeatureValueMap;

import com.shop.urshop.entity.*;
import java.util.List;

public record GetProductFeatureValueMap(Product product , FeatureValue featureValue) {
    public static List<GetProductFeatureValueMap> fromProductFeatureValueMaps(List<ProductFeatureValueMap> productFeatureValueMaps){
        return productFeatureValueMaps.stream().map(GetProductFeatureValueMap::fromProductFeatureValueMap).toList();
    }
    public static GetProductFeatureValueMap fromProductFeatureValueMap(ProductFeatureValueMap productFeatureValueMap){
        return new GetProductFeatureValueMap(productFeatureValueMap.getProduct(),productFeatureValueMap.getFeatureValue());
    }
}
