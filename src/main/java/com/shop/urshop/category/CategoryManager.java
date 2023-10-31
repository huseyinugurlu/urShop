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

  @Autowired
  public CategoryManager(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
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
  public void add(Category category) {
    this.categoryRepository.save(category);
  }

  @Override
  public void update(Category category) {
    final Category updatedCategory = getById(category.getId());
    updatedCategory.setName(category.getName());
    this.categoryRepository.save(updatedCategory);
  }

  @Override
  public void delete(int categoryId) {
    getById(categoryId);
    this.categoryRepository.deleteById(categoryId);
  }
}
