package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Address;

import java.util.List;

public interface AddressRepoService {
    List<Address> getAllAddresses();
}
