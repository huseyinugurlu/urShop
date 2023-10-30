package com.shop.urshop.product;

import com.shop.urshop.category.CategoryService;
import com.shop.urshop.entity.Product;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {
  private final ProductRepository productRepository;

  private final CategoryService categoryService;

  @Autowired
  public ProductManager(
      ProductRepository productRepository, @Lazy CategoryService categoryService) {
    this.productRepository = productRepository;
    this.categoryService = categoryService;
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
  public void add(String name, float price, int stock, String description, int categoryId) {
    Product product =
        Product.builder()
            .name(name)
            .price(price)
            .stock(stock)
            .description(description)
            .category(categoryService.getById(categoryId))
            .build();
    this.productRepository.save(product);
  }

  @Override
  public void update(
      int id, String name, float price, int stock, String description, int categoryId) {
    final Product product = getById(id);
    product.setName(name);
    product.setStock(stock);
    product.setPrice(price);
    product.setDescription(description);
    product.setCategory(categoryService.getById(categoryId));
    this.productRepository.save(product);
  }

  @Override
  public void delete(int productId) {
    getById(productId);
    this.productRepository.deleteById(productId);
  }
}
