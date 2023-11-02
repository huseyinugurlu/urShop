package com.shop.urshop.customer;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return customerRepository.findByPhoneNumber(customerNumber);
  }

  @Override
  public Customer getById(int id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new BusinessException("Customer not found!"));
  }

  @Override
  public void add(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public void update(Customer customer) {
    Customer updatedCustomer = getById(customer.getId());
    updatedCustomer.setName(customer.getName());
    updatedCustomer.setEmail(customer.getEmail());
    updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
    updatedCustomer.setPaymentCard(customer.getPaymentCard());
    customerRepository.save(updatedCustomer);
  }

  @Override
  public void delete(int id) {
    getById(id);
    this.customerRepository.deleteById(id);
  }
}
