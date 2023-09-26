package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CreateProductRequest(String name, float price,int stock, String description,Category category) {

}
