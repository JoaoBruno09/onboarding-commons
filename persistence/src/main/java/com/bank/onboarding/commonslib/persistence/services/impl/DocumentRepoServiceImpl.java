package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Document;
import com.bank.onboarding.commonslib.persistence.repositories.DocumentRepository;
import com.bank.onboarding.commonslib.persistence.services.DocumentRepoService;
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
public class DocumentRepoServiceImpl implements DocumentRepoService {

    private final DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() {
        return Optional.of(documentRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Document saveAccountDB(Document document) {
        AtomicReference<Document> documentToBeReturned = new AtomicReference<>();
        Optional.of(documentRepository.save(document)).ifPresentOrElse(documentToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar o documento na base de dados.");
        } );

        return documentToBeReturned.get();
    }
}
