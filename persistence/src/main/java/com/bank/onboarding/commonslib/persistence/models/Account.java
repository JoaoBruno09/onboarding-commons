package com.bank.onboarding.commonslib.persistence.models;

import com.bank.onboarding.commonslib.persistence.enums.ValidationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "accounts")
@Data
@Builder
public class Account {
    @Id
    private String id;
    private String accountManager;
    private Boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationTime;
    private String currencyCode;
    private String iban;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime lastUpdateTime;
    private String number;
    private Boolean onlineBankingIndicator;
    private Integer phase;
    private String type;
    private List<ValidationType> validations;
}
