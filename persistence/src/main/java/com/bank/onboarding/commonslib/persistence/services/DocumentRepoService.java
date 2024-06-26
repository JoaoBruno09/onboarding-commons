package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Document;

import java.util.List;

public interface DocumentRepoService {
    List<Document> getAllDocuments();
    Document saveDocumentDB(Document document);
    void deleteDocumentByAccountNumberOrCustomerNumber(String id, boolean isAccountDoc);
    List<Document> getAllDocumentsByAccountNumber(String accountNumber);
    List<Document> getAllDocumentsByCustomerNumber(String customerNumber);
}
