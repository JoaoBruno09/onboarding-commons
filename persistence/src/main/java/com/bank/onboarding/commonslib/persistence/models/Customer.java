package com.bank.onboarding.commonslib.persistence.models;

import com.bank.onboarding.commonslib.persistence.models.identifiers.AccountIdentifier;
import com.bank.onboarding.commonslib.persistence.models.identifiers.AddressIdentifier;
import com.bank.onboarding.commonslib.persistence.models.identifiers.ContactIdentifier;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "customers")
@Data
@Builder
public class Customer {
    @Id
    private String id;
    private List<AccountIdentifier> accounts;
    private List<AddressIdentifier> addresses;
    private String annualIncome;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime birthDate;
    private Boolean cardIndicator;
    private List<ContactIdentifier> contacts;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationTime;
    private String documentIdCountry;
    private String documentIdNumber;
    private String documentIdType;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime documentIdExpirationDate;
    private String educationLevel;
    private String fatherName;
    private String firstName;
    private String gender;
    private Boolean intervenientIndicator;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime lastUpdateTime;
    private String motherName;
    private String nationality;
    private String number;
    private Boolean onlineBankingIndicator;
    private String profession;
    private Boolean relationIndicator;
    private String taxIdCountry;
    private String taxIdNumber;
    private String taxIdType;
    private String type;
}
