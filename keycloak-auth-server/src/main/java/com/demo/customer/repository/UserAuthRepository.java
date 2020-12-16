package com.demo.customer.repository;

import com.demo.customer.model.UserAuth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
}
