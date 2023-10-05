package com.shop.urshop.productCustomerOfferMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shop.urshop.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomerOfferMapManager implements ProductCustomerOfferMapService {
  private final ProductCustomerOfferMapRepository productCustomerOfferMapRepository;
  private final ProductRepository productRepository;

  public ProductCustomerOfferMapManager(
          ProductCustomerOfferMapRepository productCustomerOfferMapRepository, ProductRepository productRepository) {
    this.productCustomerOfferMapRepository = productCustomerOfferMapRepository;
    this.productRepository = productRepository;
  }

  @Override
  public List<ProductCustomerOfferMap> getAll() {
    return productCustomerOfferMapRepository.findAll();
  }

  @Override
  public List<ProductCustomerOfferMap> getMapsByProductId(int productId) {
    Optional<Product> productOptional = productRepository.findById(productId);

      Product product = productOptional.get();
    List<ProductCustomerOfferMap> maps = new ArrayList<>();;
      maps.add(productCustomerOfferMapRepository.findByProduct(product));
      return maps;

  }


}
