package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContactType {
    TELEPHONE("Telemóvel"),
    EMAIL("E-mail");

    private final String value;
}
