package com.bank.onboarding.commonslib.persistence.models.identifiers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressIdentifier {
    private String addressId;
}
