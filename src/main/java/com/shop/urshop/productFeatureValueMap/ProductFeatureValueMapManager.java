package com.shop.urshop.productFeatureValueMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductFeatureValueMap;
import com.shop.urshop.product.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shop.urshop.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFeatureValueMapManager implements ProductFeatureValueMapService {

  private final ProductFeatureValueMapRepository productFeatureValueMapRepository;

  private final ProductService productService;

  @Autowired
  public ProductFeatureValueMapManager(
      ProductFeatureValueMapRepository productFeatureValueMapRepository,
      ProductService productService) {
    this.productFeatureValueMapRepository = productFeatureValueMapRepository;
    this.productService = productService;
  }

  @Override
  public List<ProductFeatureValueMap> getAll() {
    return productFeatureValueMapRepository.findAll();
  }

  @Override
  public List<ProductFeatureValueMap> getMapsByFeatureId(int featureId) {
    return productFeatureValueMapRepository.findProductFeatureValueMapByFeatureValue_Id(featureId);
  }

  @Override
  public List<ProductFeatureValueMap> getMapsByProductId(int productId) {
    Product product =  productService.getById(productId);
    List<ProductFeatureValueMap> maps = new ArrayList<>();
    maps.add(productFeatureValueMapRepository.findByProduct(product));
    return maps;
  }
}
