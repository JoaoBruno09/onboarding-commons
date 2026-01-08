package com.bank.onboarding.commonslib.persistence.models;

import com.bank.onboarding.commonslib.persistence.models.identifiers.AccountIdentifier;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customersRef")
@Data
@Builder
public class CustomerRef {
    @Id
    private String id;
    private String customerNumber;
    private boolean isValid;
    private List<AccountIdentifier> accounts;
}
