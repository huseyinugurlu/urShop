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
  public List<Product> getByCategory(int categoryId) {
    return productRepository.findProductByCategory_id(categoryId);
  }

  @Override
  public void add(Product product) {
    this.productRepository.save(product);
  }

  @Override
  public void update(Product product) {
    final Product updatedProduct = getById(product.getId());
    updatedProduct.setName(product.getName());
    updatedProduct.setStock(product.getStock());
    updatedProduct.setPrice(product.getPrice());
    updatedProduct.setDescription(product.getDescription());
    updatedProduct.setCategory(product.getCategory());
    this.productRepository.save(updatedProduct);
  }

  @Override
  public void delete(int productId) {
    getById(productId);
    this.productRepository.deleteById(productId);
  }
}
