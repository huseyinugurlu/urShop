package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Product;
import java.util.List;

public record GetAllProductsResponse(
    int id, String name, float price, int stock, String description, Integer categoryId) {
  public static List<GetAllProductsResponse> fromProducts(List<Product> products) {
    return products.stream().map(GetAllProductsResponse::fromProducts).toList();
  }

  public static GetAllProductsResponse fromProducts(Product product) {
    return new GetAllProductsResponse(
        product.getId(),
        product.getName(),
        product.getPrice(),
        product.getStock(),
        product.getDescription(),
        product.getCategory().getId());
  }
}
