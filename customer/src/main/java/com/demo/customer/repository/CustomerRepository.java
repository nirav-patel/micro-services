package com.demo.customer.repository;

import com.demo.customer.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

  @Query("FROM Customer c")
  List<Customer> getAllCustomers();

}
