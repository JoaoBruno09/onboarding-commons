package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Account;

import java.util.List;

public interface AccountRepoService {

    List<Account> findAccountsDB();
    Account getAccountByNumber(String accountNumber);
    Account saveAccountDB(Account account);
    void deleteAccountById(String accountId);
    Account getAccountById(String accountId);
}
