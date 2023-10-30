package com.shop.urshop.controller.product;

public record CreateProductRequest(
    String name, float price, int stock, String description, int categoryId) {}
