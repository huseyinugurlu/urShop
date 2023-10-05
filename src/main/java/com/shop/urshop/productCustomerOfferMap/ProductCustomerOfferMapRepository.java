package com.shop.urshop.productCustomerOfferMap;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCustomerOfferMapRepository extends JpaRepository<ProductCustomerOfferMap, Integer> {
    ProductCustomerOfferMap findByProduct(Product product);

}
