package com.shop.urshop.customer;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByCustomerNumber(long customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        if (customerRepository.existsById(customer.getId())){
            customerRepository.save(customer);
        }else {
            throw new RuntimeException("Customer not found!");
        }
    }

    @Override
    public void delete(int customerNumber) {
        this.customerRepository.deleteById(customerNumber);
    }
}
