package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.AccountRef;

public interface AccountRefRepoService {
    void saveAccountRefDB(AccountRef accountRef);
    void deleteAccountById(String accountId);
}
