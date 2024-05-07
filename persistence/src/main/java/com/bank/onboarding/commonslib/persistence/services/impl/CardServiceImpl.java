package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.persistence.repositories.CardRepository;
import com.bank.onboarding.commonslib.persistence.services.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return Optional.of(cardRepository.findAll()).orElse(Collections.emptyList());
    }
}
