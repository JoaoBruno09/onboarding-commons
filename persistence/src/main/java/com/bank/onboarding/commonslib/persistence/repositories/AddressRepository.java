package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
