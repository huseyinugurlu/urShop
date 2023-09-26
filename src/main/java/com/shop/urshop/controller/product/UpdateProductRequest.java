package com.shop.urshop.controller.product;

import com.shop.urshop.entity.Category;

public record UpdateProductRequest (int id, String name,float price,int stock,String description,Category category){
   
}
