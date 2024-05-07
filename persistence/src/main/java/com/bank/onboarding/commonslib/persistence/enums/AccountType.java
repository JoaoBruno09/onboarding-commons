package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountType {
    ORDEM("Conta à ordem"),
    BASE("Conta base"),
    SMB("Conta de Serviços Minimos Bancários"),
    POUPANCA("Conta poupança"),
    ORDENADO("Conta ordenado"),
    UNIV("Conta para universitários"),
    EMP("Conta bancária empresarial"),
    JOV("Conta jovem");

    private final String value;
}
