package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRefRepository;
import com.bank.onboarding.commonslib.persistence.services.CustomerRefRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class CustomerRefRepoServiceImpl implements CustomerRefRepoService {

    private final CustomerRefRepository customerRefRepository;

    @Override
    public CustomerRef findCustomerRefByCustomerNumber(String customerNumber) {
        return Optional.ofNullable(customerRefRepository.findByCustomerNumber(customerNumber)).orElse(CustomerRef.builder().build());
    }

    @Override
    public CustomerRef findCustomerRefByCustomerId(String customerId) {
        return Optional.of(customerRefRepository.findById(customerId)).get().orElse(null);
    }

    @Override
    public void saveCustomerRefDB(CustomerRef customerRef) {
        Optional.of(customerRefRepository.save(customerRef)).orElseThrow(() ->
                new OnboardingException("Ocorreu um erro a guardar o cliente na base de dados."));
    }

    @Override
    public void deleteCustomerByNumber(String customerNumber) {
        customerRefRepository.deleteByCustomerNumber(customerNumber);
    }

    @Override
    public List<CustomerRef> getCustomersByAccountsAccountNumber(String accountNumber) {
        return Optional.ofNullable(customerRefRepository.findAllByAccountsAccountNumber(accountNumber)).orElse(Collections.emptyList());
    }
}
