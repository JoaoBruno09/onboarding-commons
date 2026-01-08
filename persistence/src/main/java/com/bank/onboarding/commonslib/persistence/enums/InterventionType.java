package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterventionType {
    TT("Titular"),
    PRL("Progenitor/Representante Legal"),
    TTR("Tutor"),
    CR("Curador"),
    AB("Administrador de Bens"),
    AI("Administrador de Insolvência"),
    CC("Cabeça de Casal"),
    DR("Director"),
    SG("Sócio-Gerente"),
    AD("Administrador"),
    G("Gerente"),
    A("Autorizado"),
    PC("Procurador");

    private final String value;
}
