package com.shop.urshop.product;

import com.shop.urshop.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findProductByCategory_id(Integer id);
}
