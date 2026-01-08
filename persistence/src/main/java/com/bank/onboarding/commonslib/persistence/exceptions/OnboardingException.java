package com.bank.onboarding.commonslib.persistence.exceptions;

public class OnboardingException extends RuntimeException {
    public OnboardingException(String errorMessage) {
        super(errorMessage);
    }
}
