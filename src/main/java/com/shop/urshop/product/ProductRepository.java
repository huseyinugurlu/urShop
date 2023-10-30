package com.shop.urshop.product;

import com.shop.urshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findProductByCategory_id(Integer id);
}
