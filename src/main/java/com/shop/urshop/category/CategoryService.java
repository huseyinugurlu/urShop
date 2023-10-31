package com.shop.urshop.category;

import com.shop.urshop.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
  List<Category> getAll();

  Category getById(int categoryId);

  void add(Category category);

  void update(Category category);

  void delete(int categoryId);
}
