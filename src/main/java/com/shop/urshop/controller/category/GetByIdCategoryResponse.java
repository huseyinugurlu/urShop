package com.shop.urshop.controller.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;
import java.util.Set;
import java.util.stream.Collectors;

public record GetByIdCategoryResponse(int id, String name, Set<Integer> productIds) {
  public static GetByIdCategoryResponse fromCategory(Category category) {
    return new GetByIdCategoryResponse(
        category.getId(),
        category.getName(),
        category.getProducts().stream().map(Product::getId).collect(Collectors.toSet()));
  }
}
