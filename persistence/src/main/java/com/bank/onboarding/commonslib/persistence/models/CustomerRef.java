package com.bank.onboarding.commonslib.persistence.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customersRef")
@Data
@Builder
public class CustomerRef {
    @Id
    private String id;
    private String customerNumber;
}
