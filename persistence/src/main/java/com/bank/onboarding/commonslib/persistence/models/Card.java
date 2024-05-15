package com.bank.onboarding.commonslib.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
@Data
@AllArgsConstructor
@Builder
public class Card {
    @Id
    private String id;
    private Double annualFee;
    private Integer cvc;
    private String number;
    private String type;
    private String accountId;
    private String customerId;
}
