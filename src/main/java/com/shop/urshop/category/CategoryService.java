package com.shop.urshop.category;

import com.shop.urshop.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
  List<Category> getAll();

  Category getById(int categoryId);

  void add(String categoryName, Set<Integer> productIds);

  void update(int id, String name);

  void delete(int categoryId);
}
