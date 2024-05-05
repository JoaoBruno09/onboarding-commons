package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
}
