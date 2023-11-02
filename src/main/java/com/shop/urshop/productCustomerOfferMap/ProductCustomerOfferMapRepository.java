package com.shop.urshop.productCustomerOfferMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCustomerOfferMapRepository
    extends JpaRepository<ProductCustomerOfferMap, Integer> {
  List<ProductCustomerOfferMap> findProductCustomerOfferMapByProduct_id(Integer id);

  ProductCustomerOfferMap findByProduct(Product product);
}
