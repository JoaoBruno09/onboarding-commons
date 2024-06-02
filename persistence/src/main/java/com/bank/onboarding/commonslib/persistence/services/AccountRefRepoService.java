package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.AccountRef;

public interface AccountRefRepoService {
    AccountRef findAccountRefByAccountNumber(String accountNumber);
    void saveAccountRefDB(AccountRef accountRef);
    void deleteAccountById(String accountId);
}
