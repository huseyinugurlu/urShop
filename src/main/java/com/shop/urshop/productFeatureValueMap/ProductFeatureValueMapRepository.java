package com.shop.urshop.productFeatureValueMap;

import com.shop.urshop.entity.FeatureValue;
import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import com.shop.urshop.entity.ProductFeatureValueMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFeatureValueMapRepository extends JpaRepository<ProductFeatureValueMap, Integer> {
    ProductFeatureValueMap findByFeatureValue(FeatureValue featureValue);

    ProductFeatureValueMap findByProduct(Product product);
}
