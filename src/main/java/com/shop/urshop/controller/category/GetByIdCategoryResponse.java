package com.shop.urshop.controller.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Product;
import java.util.Set;

public record GetByIdCategoryResponse(String name, Set<Product> products){
    public static GetByIdCategoryResponse fromCategory(Category category){
        return new GetByIdCategoryResponse(category.getCategoryName(),category.getProducts());
    }
}

