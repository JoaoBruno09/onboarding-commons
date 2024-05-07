package com.bank.onboarding.commonslib.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
@Data
@AllArgsConstructor
public class Address {
    @Id
    private String id;
    private String city;
    private String country;
    private String street;
    private String zip;
}
