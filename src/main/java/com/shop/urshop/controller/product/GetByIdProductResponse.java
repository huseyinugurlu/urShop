package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Product;

public record GetByIdProductResponse(
    int id, String name, float price, int stock, String description, int categoryId) {
  public static GetByIdProductResponse fromProduct(Product product) {
    return new GetByIdProductResponse(
        product.getId(),
        product.getName(),
        product.getPrice(),
        product.getStock(),
        product.getDescription(),
        product.getCategory().getId());
  }
}
