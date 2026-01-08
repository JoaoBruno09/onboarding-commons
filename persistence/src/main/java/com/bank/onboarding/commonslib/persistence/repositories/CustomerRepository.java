package com.bank.onboarding.commonslib.persistence.repositories;

import com.bank.onboarding.commonslib.persistence.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByNumber(String customerNumber);
    void deleteByNumber(String customerNumber);
    List<Customer> findAllByNumber(String customerNumber);
}
