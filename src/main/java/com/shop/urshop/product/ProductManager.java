package com.shop.urshop.product;

import com.shop.urshop.entity.Product;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductManager(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Override
  public Product getById(int productId) {
    return productRepository
        .findById(productId)
        .orElseThrow(() -> new BusinessException("Product not found!"));
  }

  @Override
  public void add(Product product) {
    this.productRepository.save(product);
  }

  @Override
  public void update(Product product) {
    if (productRepository.existsById(product.getProductId())) {
      this.productRepository.save(product);
    } else {
      throw new BusinessException("Product not found!");
    }
  }

  @Override
  public void delete(int productId) {
    if (productRepository.existsById(productId)) {
      this.productRepository.deleteById(productId);
    } else {
      throw new BusinessException("Product not found!");
    }
  }
}
