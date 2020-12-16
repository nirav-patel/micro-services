package com.demo.customer.service;

import com.demo.customer.model.Customer;
import com.demo.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> fetchAllCustomers() {
    log.info("Fetching all customers information.");
    return customerRepository.getAllCustomers();
  }

  @Override
  public Customer fetchCustomerById(String id) {
    log.info("Fetching customer for id : {}", id);
    return customerRepository.findById(id).get();
  }

  @Override
  public Customer saveCustomerInfo(Customer customer) {
    log.info("Save customer information.");
    return customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(String id) {
    log.info("Delete customer information for id : {}", id);
    customerRepository.deleteById(id);
  }

}
