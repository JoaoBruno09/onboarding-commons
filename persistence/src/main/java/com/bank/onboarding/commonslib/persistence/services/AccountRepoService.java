package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Account;

import java.util.List;

public interface AccountRepoService {

    List<Account> findAccountsDB();
    Account findAccountDB(String accountNumber);
    Account saveAccountDB(Account account);
}
