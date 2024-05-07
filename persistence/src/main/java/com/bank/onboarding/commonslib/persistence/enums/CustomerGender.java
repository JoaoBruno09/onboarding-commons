package com.bank.onboarding.commonslib.persistence.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CustomerGender {
    MALE("male"),
    FEMALE("female");

    private final String value;
}
