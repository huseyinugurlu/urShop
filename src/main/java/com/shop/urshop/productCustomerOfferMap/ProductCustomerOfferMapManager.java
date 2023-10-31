package com.shop.urshop.productCustomerOfferMap;

import com.shop.urshop.entity.ProductCustomerOfferMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomerOfferMapManager implements ProductCustomerOfferMapService {
  private final ProductCustomerOfferMapRepository productCustomerOfferMapRepository;

  @Autowired
  public ProductCustomerOfferMapManager(
      ProductCustomerOfferMapRepository productCustomerOfferMapRepository) {
    this.productCustomerOfferMapRepository = productCustomerOfferMapRepository;
  }

  @Override
  public List<ProductCustomerOfferMap> getAll() {
    return productCustomerOfferMapRepository.findAll();
  }

  @Override
  public List<ProductCustomerOfferMap> getMapsByProductId(int productId) {
    return productCustomerOfferMapRepository.findProductCustomerOfferMapByProduct_id(
        productId);
  }
}
