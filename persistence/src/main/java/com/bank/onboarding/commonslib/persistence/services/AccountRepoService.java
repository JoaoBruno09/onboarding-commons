package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Account;

import java.util.List;

public interface AccountRepoService {

    List<Account> findAccountsDB();
    Account saveAccountTypeDB(Account account, String accountType);
    Account findAccountDB(String accountNumber);
    Boolean saveAccountDB(Account account);
}
