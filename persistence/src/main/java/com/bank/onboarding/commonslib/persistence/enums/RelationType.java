package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RelationType {
    TT("Tutor"),
    PG("Progenitor"),
    PC("Procurador"),
    AD("Adminitrador"),
    G("Gerente"),
    D("Diretor"),
    CC("Cabeça de Casal"),
    SG("Sócio-Gerente");

    private final String value;
}
