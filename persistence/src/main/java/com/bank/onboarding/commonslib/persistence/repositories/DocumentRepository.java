package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DocumentRepository extends MongoRepository<Document, String> {
    Document findByAccountNumber(String accountNumber);
    Document findByCustomerNumber(String customerNumber);
    List<Document> findAllByAccountNumber(String accountNumber);
    List<Document> findAllByCustomerNumber(String customerNumber);
}
