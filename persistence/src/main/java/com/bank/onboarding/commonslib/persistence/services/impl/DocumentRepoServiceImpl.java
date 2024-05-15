package com.bank.onboarding.commonslib.persistence.services.impl;

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
}
