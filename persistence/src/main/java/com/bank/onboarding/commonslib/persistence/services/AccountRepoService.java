package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Account;

import java.util.List;

public interface AccountRepoService {
    Account getAccountByNumber(String accountNumber);
    Account saveAccountDB(Account account);
    void deleteAccountByAccountNumber(String accountNumber);
    Account getAccountById(String accountId);
    List<Account> getAccountsByIBAN(String iban);
}
