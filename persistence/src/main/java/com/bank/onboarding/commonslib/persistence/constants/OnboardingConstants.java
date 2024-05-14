package com.bank.onboarding.commonslib.persistence.constants;

import com.bank.onboarding.commonslib.persistence.enums.AccountType;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class OnboardingConstants {
    public static final List<String> PARTICULAR_ACCOUNT_TYPES = List.of(AccountType.ORDEM.name(), AccountType.BASE.name(), AccountType.SMB.name(), AccountType.POUPANCA.name(), AccountType.ORDENADO.name());
    public static final List<String> EMPRESA_ACCOUNT_TYPES = List.of(AccountType.EMP.name());
    public static final List<String> MINOR_ACCOUNT_TYPES = List.of(AccountType.JOV.name());
    public static final List<String> STUDENT_ACCOUNT_TYPES = List.of(AccountType.UNIV.name());
    public static final List<String> ACCOUNT_TYPES = new ArrayList<>();

    @PostConstruct
    private void addAllAccountTypes(){
        ACCOUNT_TYPES.addAll(PARTICULAR_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(EMPRESA_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(MINOR_ACCOUNT_TYPES);
        ACCOUNT_TYPES.addAll(STUDENT_ACCOUNT_TYPES);
    }
}
