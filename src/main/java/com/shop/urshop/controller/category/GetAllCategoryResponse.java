package com.shop.urshop.controller.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;

import java.util.List;
import java.util.Set;

public record GetAllCategoryResponse(String name, Set<Product> products) {
    public static List<GetAllCategoryResponse> fromCategories(List<Category> categories){
        return categories.stream().map(GetAllCategoryResponse::fromCategory).toList();
    }
    public static GetAllCategoryResponse fromCategory(Category category){
        return new GetAllCategoryResponse(category.getCategoryName(),category.getProducts());
    }
}
