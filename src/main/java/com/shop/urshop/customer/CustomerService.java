package com.shop.urshop.customer;

import com.shop.urshop.entity.Category;
import com.shop.urshop.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer getByCustomerNumber(long customerNumber);

    void add(Customer customer);

    void update(Customer customer);

    void delete(int customerNumber);
}
