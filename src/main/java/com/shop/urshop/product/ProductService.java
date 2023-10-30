package com.shop.urshop.product;

import com.shop.urshop.entity.Product;

import java.util.List;

public interface ProductService {
  List<Product> getAll();

  Product getById(int productId);

  List<Product> getByCategory(int productId);

  void add(String name, float price, int stock, String description, int categoryId);

  void update(int id, String name, float price, int stock, String description, int categoryId);

  void delete(int productId);
}
