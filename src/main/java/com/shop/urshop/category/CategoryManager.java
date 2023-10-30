package com.shop.urshop.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.exception.BusinessException;
import com.shop.urshop.product.ProductService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {
  private final CategoryRepository categoryRepository;
  private final ProductService productService;

  @Autowired
  public CategoryManager(
      CategoryRepository categoryRepository, @Lazy ProductService productService) {
    this.categoryRepository = categoryRepository;
    this.productService = productService;
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(int categoryId) {
    return categoryRepository
        .findById(categoryId)
        .orElseThrow(() -> new BusinessException("Category not found!"));
  }

  @Override
  public void add(String categoryName, Set<Integer> productIds) {
    final Category category =
        Category.builder()
                .name(categoryName)
            .products(productIds.stream().map(productService::getById).collect(Collectors.toSet()))
            .build();
    this.categoryRepository.save(category);
  }

  @Override
  public void update(int id, String name) {
    final Category category = getById(id);
    category.setName(name);
    this.categoryRepository.save(category);
  }

  @Override
  public void delete(int categoryId) {
    getById(categoryId);
    this.categoryRepository.deleteById(categoryId);
  }
}
