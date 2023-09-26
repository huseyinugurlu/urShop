package com.shop.urshop.controller.category;

import com.shop.urshop.entity.Product;
import java.util.Set;

public record CreateCategoryRequest(String name,Set<Product> products) {
  
}
