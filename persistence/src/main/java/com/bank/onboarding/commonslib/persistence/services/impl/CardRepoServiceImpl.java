package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.persistence.repositories.CardRepository;
import com.bank.onboarding.commonslib.persistence.services.CardRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.bank.onboarding.commonslib.persistence.enums.CardType.CC;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CD;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CDD;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CDM;
import static com.bank.onboarding.commonslib.persistence.enums.CardType.CPP;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class CardRepoServiceImpl implements CardRepoService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return Optional.of(cardRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Boolean saveCardDB(Card card) {
        if(cardRepository.save(card).getId() != null) return Boolean.TRUE;

        throw new OnboardingException("Ocorreu um erro a guardar o cartão na base de dados.");
    }

    @Override
    public String getCardTypeValue(String cardType) {
        String cardTypeValue = "";
        if(CD.name().equals(cardType)){
            cardTypeValue = CD.getValue();
        } else if (CC.name().equals(cardType)) {
            cardTypeValue = CC.getValue();
        } else if (CDD.name().equals(cardType)) {
            cardTypeValue = CDD.getValue();
        } else if (CPP.name().equals(cardType)) {
            cardTypeValue = CPP.getValue();
        } else if (CDM.name().equals(cardType)) {
            cardTypeValue = CDM.getValue();
        }

        return cardTypeValue;
    }

    @Override
    public Card findCardDB(String cardNumber) throws OnboardingException {
        return Optional.ofNullable(cardRepository.findByNumber(cardNumber)).orElseThrow(() ->
                new OnboardingException("Não foi encontrado nenhum cartão com o número " + cardNumber));
    }

    @Override
    public Card deleteCardDB(String cardId) {
        cardRepository.deleteById(cardId);
        return null;
    }
}
