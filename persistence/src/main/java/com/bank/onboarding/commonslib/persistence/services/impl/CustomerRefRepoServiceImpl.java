package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRefRepository;
import com.bank.onboarding.commonslib.persistence.services.CustomerRefRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class CustomerRefRepoServiceImpl implements CustomerRefRepoService {

    private final CustomerRefRepository customerRefRepository;

    @Override
    public CustomerRef findCustomerDB(String customerNumber) {
        return customerRefRepository.findByCustomerNumber(customerNumber);
    }
}
