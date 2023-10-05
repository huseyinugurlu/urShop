package com.shop.urshop.productFeatureValueMap;

import com.shop.urshop.entity.ProductFeatureValueMap;
import java.util.List;

public interface ProductFeatureValueMapService {
    List<ProductFeatureValueMap> getAll();

    List<ProductFeatureValueMap> getMapsByFeatureId(int featureId);

    List<ProductFeatureValueMap> getMapsByProductId(int featureId);
}
