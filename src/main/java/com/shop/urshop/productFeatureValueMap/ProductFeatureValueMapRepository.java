package com.shop.urshop.productFeatureValueMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductFeatureValueMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFeatureValueMapRepository
    extends JpaRepository<ProductFeatureValueMap, Integer> {
  List<ProductFeatureValueMap> findProductFeatureValueMapByFeatureValue_Id(Integer id);

  ProductFeatureValueMap findByProduct(Product product);
}
