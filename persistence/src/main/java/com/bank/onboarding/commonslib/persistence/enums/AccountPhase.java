package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountPhase {
    INTYPE(1),
    RELCARD(2),
    DOCS(3),
    TERMINADA(4);
    private final Integer value;
}
