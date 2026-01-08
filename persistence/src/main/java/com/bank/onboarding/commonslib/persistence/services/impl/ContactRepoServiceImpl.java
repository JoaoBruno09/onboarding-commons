package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.services.ContactRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ContactRepoServiceImpl implements ContactRepoService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return Optional.of(contactRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Contact saveContactDB(Contact contact) {
        AtomicReference<Contact> contactToBeReturned = new AtomicReference<>();
        Optional.of(contactRepository.save(contact)).ifPresentOrElse(contactToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar o contacto na base de dados.");
        } );

        return contactToBeReturned.get();
    }
}
