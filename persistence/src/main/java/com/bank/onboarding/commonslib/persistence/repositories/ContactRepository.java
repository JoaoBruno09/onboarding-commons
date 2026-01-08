package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
