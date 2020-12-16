package com.demo.account.controller;

import com.demo.account.model.Account;
import com.demo.account.service.AccountService;

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
@RequestMapping(value = "/api/accounts",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/")
  public ResponseEntity<Collection<Account>> getAllAccounts() {
    log.info("Fetch all account information.");
    List<Account> listAccounts = accountService.fetchAllAccounts();
    return new ResponseEntity<>(listAccounts, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Account> getAccount(@PathVariable("id") long accountId) {
    log.info("Fetch account information for id: {}", accountId);
    Account account = accountService.fetchAccountById(accountId);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Account> updateAccount(@PathVariable("id") long accountId,
                                               @RequestBody final Account account) {
    log.info("Edit account information for id: {}", accountId);
    Account savedAccount = accountService.saveAccountInfo(account);
    return new ResponseEntity<>(savedAccount, HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") long accountId) {
    log.info("Delete account information for id: {}", accountId);
    accountService.deleteAccount(accountId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value = "/")
  public ResponseEntity<Account> createAccount(@RequestBody final Account account) {
    log.info("Create new account");
    Account savedAccount = accountService.saveAccountInfo(account);
    return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
  }
}