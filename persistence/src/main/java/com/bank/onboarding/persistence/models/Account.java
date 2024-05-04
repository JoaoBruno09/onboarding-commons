package com.bank.onboarding.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    private String accountManager;
    private LocalDateTime creationTime;
    private String currencyCode;
    private String iban;
    private LocalDateTime lastUpdateTime;
    private String number;
    private Boolean onlineBankingIndicator;
    private String type;
}
