package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
}
