package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;

import java.util.List;

public record GetAllProductsResponse(
    String name, float price, int stock, String description, Category category) {
    public static List<GetAllProductsResponse> fromProducts(List<Product> products){
        return products.stream().map(GetAllProductsResponse::fromProducts).toList();
    }
    public static GetAllProductsResponse fromProducts(Product product){
        return new GetAllProductsResponse(product.getProductName(),product.getPrice(),product.getStock(),product.getDescription(),product.getCategory());
    }
}
