package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import com.bank.onboarding.commonslib.persistence.services.CustomerRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class CustomerRepoServiceImpl implements CustomerRepoService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return Optional.of(customerRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Customer saveCustomerDB(Customer customer) {
        AtomicReference<Customer> customerToBeReturned = new AtomicReference<>();
        Optional.of(customerRepository.save(customer)).ifPresentOrElse(customerToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar o cliente na base de dados.");
        } );

        return customerToBeReturned.get();
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return Optional.of(customerRepository.findById(customerId)).get().orElse(null);
    }

    @Override
    public Customer getCustomerByNumber(String customerNumber) {
        return Optional.of(customerRepository.findByNumber(customerNumber)).orElse(null);
    }
}
