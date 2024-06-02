package com.bank.onboarding.commonslib.persistence.services.impl;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.bank.onboarding.commonslib.persistence.models.Address;
import com.bank.onboarding.commonslib.persistence.repositories.AddressRepository;
import com.bank.onboarding.commonslib.persistence.services.AddressRepoService;
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
public class AddressRepoServiceImpl implements AddressRepoService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return Optional.of(addressRepository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Address saveAddressDB(Address address) {
        AtomicReference<Address> addressToBeReturned = new AtomicReference<>();
        Optional.of(addressRepository.save(address)).ifPresentOrElse(addressToBeReturned::set, () -> {
            throw new OnboardingException("Ocorreu um erro a guardar a morada na base de dados.");
        } );

        return addressToBeReturned.get();
    }
}
