package com.demo.customer.controller;

import com.demo.customer.model.Customer;
import com.demo.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/customers",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/")
  public ResponseEntity<Collection<Customer>> getAllCustomers() {
    log.info("Fetch all customer information.");
    List<Customer> listCustomers = customerService.fetchAllCustomers();
    return new ResponseEntity<>(listCustomers, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("id") String customerId) {
    log.info("Fetch customer information for id: {}", customerId);
    Customer customer = customerService.fetchCustomerById(customerId);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long customerId,
                                               @RequestBody final Customer customer) {
    log.info("Edit customer information for id: {}", customerId);
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") String customerId) {
    log.info("Delete customer information for id: {}", customerId);
    customerService.deleteCustomer(customerId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value = "/")
  public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {
    log.info("Create new customer");
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
  }
}