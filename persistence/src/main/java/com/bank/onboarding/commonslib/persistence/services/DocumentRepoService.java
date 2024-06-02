package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Document;

import java.util.List;

public interface DocumentRepoService {
    List<Document> getAllDocuments();
    Document saveDocumentDB(Document document);
    void deleteDocumentByAccountIdOrCustomerId(String id, boolean isAccountDoc);
}
