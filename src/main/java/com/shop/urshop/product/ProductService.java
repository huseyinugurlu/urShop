package com.shop.urshop.product;

import com.shop.urshop.entity.Product;

import java.util.List;


public interface ProductService {
    List<Product> getAll();

    Product getById(int productId);

    void add(Product product);

    void update(Product product);

    void delete(int productId);
}
