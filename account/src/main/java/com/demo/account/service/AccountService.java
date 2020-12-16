package com.demo.account.service;

import com.demo.account.model.Account;

import java.util.List;

public interface AccountService {

  List<Account> fetchAllAccounts();

  Account fetchAccountById(long id);

  Account saveAccountInfo(Account account);

  void deleteAccount(long id);
}
