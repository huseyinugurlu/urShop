package com.shop.urshop.productCustomerOfferMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;

import java.util.List;

public interface ProductCustomerOfferMapService {
  List<ProductCustomerOfferMap> getAll();

  List<ProductCustomerOfferMap> getMapsByProductId(int productId);

}
