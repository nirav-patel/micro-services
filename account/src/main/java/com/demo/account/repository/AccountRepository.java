package com.demo.account.repository;

import com.demo.account.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Query("FROM Account a")
  List<Account> getAllAccounts();

  @Query("SELECT a FROM Account a WHERE a.id = :id")
  Account findById(@Param("id") long id);

}
