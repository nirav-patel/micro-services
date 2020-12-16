package com.demo.account.service;

import com.demo.account.client.CustomerServiceClient;
import com.demo.account.model.Account;
import com.demo.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private CustomerServiceClient customerServiceClient;

  @Override
  public List<Account> fetchAllAccounts() {
    log.info("Fetching all accounts information.");
    return accountRepository.getAllAccounts();
  }

  @Override
  public Account fetchAccountById(long id) {
    log.info("Fetching account for id : {}", id);
    return accountRepository.findById(id);
  }

  @Override
  public Account saveAccountInfo(Account account) {
    log.info("Save account information.");
    account.setCustomer(customerServiceClient.createCustomer(account.getCustomer()));
    return accountRepository.save(account);
  }

  @Override
  public void deleteAccount(long id) {
    log.info("Delete account information for id : {}", id);
    accountRepository.deleteById(id);
  }

}
