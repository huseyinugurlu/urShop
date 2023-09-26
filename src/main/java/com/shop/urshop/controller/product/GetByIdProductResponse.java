package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;

public record GetByIdProductResponse (
        String name, float price, int stock, String description, Category category){
    public static GetByIdProductResponse fromProduct(Product product){
        return new GetByIdProductResponse(product.getProductName(), product.getPrice(),product.getStock(), product.getDescription(), product.getCategory());
    }
}
