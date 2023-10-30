package com.shop.urshop.controller.product;

public record UpdateProductRequest(
    String name, float price, int stock, String description, int categoryId) {}
