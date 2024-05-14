package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {
    CD("Cartão de débito"),
    CC("Cartão de crédito"),
    CDD("Cartão de débito diferido"),
    CPP("Cartão pré-pago"),
    CDM("Cartão dual ou misto");

    private final String value;
}
