package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DocumentRepository extends MongoRepository<Document, String> {
    Document findByAccountId(String accountId);
    Document findByCustomerId(String customerId);
    List<Document> findAllByAccountId(String accountId);
    List<Document> findAllByCustomerId(String customerId);
}
