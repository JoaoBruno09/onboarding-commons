package com.bank.onboarding.commonslib.utils;

import com.bank.onboarding.commonslib.web.dtos.account.AccountDTO;
import com.bank.onboarding.commonslib.persistence.models.Account;

import java.time.LocalDateTime;

public interface OnboardingUtils {
    boolean isEmpresaAccountType(String accountType);
    boolean isParticularAccountType(String accountType);
    Boolean isMinorAndHasProgenitorOrTutorAndAccountTypeIsJOV(int age, String customerType);
    Boolean isMajorAndUniversityStudentAndAccountTypeIsUNIV(Integer age, String customerProfession, String customerType);
    int calculateAge(LocalDateTime birthDate);
    AccountDTO saveAccountTypeDB(Account account, String accountType);
    Account findAccountDB(String accountNumber);
    Boolean saveAccountDB(Account account);
}
