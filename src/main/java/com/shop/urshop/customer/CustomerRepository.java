package com.shop.urshop.customer;

import com.shop.urshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerNumber(long customerNumber);
}
