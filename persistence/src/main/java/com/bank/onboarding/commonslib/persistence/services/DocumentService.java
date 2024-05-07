package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAllDocuments();
}
