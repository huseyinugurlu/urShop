package com.shop.urshop.order;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.urshop.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
