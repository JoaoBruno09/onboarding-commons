package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Card;

import java.util.List;

public interface CardRepoService {
    List<Card> getAllCards();
    Boolean saveCardDB(Card card);
    String getCardTypeValue (String cardType);
    Card findCardDB(String cardNumber);
    Card deleteCardDB(String cardNumber);
    void findAndDeleteCardDB(String customerId, String accountId);
}
