package com.shop.urshop.controller.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record GetAllCategoryResponse(int id, String name, Set<Integer> productIds) {
  public static List<GetAllCategoryResponse> fromCategories(List<Category> categories) {
    return categories.stream().map(GetAllCategoryResponse::fromCategory).toList();
  }

  public static GetAllCategoryResponse fromCategory(Category category) {
    return new GetAllCategoryResponse(
        category.getId(),
        category.getName(),
        category.getProducts().stream().map(Product::getId).collect(Collectors.toSet()));
  }
}
