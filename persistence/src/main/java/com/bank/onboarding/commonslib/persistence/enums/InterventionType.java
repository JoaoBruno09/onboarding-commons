package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterventionType {
    TT("Titular"),
    AD("Administrador");

    private final String value;
}
