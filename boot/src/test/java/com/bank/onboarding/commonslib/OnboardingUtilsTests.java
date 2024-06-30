package com.bank.onboarding.commonslib;

import com.bank.onboarding.commonslib.persistence.enums.AccountType;
import com.bank.onboarding.commonslib.persistence.enums.CardType;
import com.bank.onboarding.commonslib.persistence.enums.ContactType;
import com.bank.onboarding.commonslib.persistence.enums.CustomerType;
import com.bank.onboarding.commonslib.persistence.enums.DocumentType;
import com.bank.onboarding.commonslib.persistence.enums.InterventionType;
import com.bank.onboarding.commonslib.persistence.enums.RelationType;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Address;
import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.persistence.models.Document;
import com.bank.onboarding.commonslib.persistence.models.Intervention;
import com.bank.onboarding.commonslib.persistence.models.Relation;
import com.bank.onboarding.commonslib.persistence.models.identifiers.AccountIdentifier;
import com.bank.onboarding.commonslib.persistence.models.identifiers.ContactIdentifier;

import java.time.LocalDateTime;
import java.util.List;

public class OnboardingUtilsTests {

    public static Account buildAccount(){
        String iban = "PT50 0000 2927 8040 8012 4082 5";
        return Account.builder()
                .accountManager("Mário Ferreira Neves")
                .active(Boolean.FALSE)
                .creationTime(LocalDateTime.now())
                .currencyCode("EUR")
                .iban(iban)
                .lastUpdateTime(LocalDateTime.now())
                .number(iban.trim().replaceAll(" ", "").substring(iban.length()-19))
                .onlineBankingIndicator(Boolean.FALSE)
                .phase(1)
                .type(AccountType.ORDEM.name())
                .build();
    }

    public static Address buildAddress(){
        return Address.builder()
                .city("Porto")
                .country("Portugal")
                .street("Rua do Carmo")
                .zip("4050-164")
                .build();
    }

    public static Card builCard(){
        return Card.builder()
                .annualFee(5.00)
                .cvc(123)
                .number("1234-5678-9103-1213")
                .type(CardType.CD.name()).build();
    }

    public static Contact buildContact(){
        return Contact.builder()
                .type(ContactType.TELEPHONE.getValue())
                .value("911234567")
                .creationTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    public static Customer buildCustomer(String accountNumber, String contactId){
        return Customer.builder()
                .accounts(List.of(AccountIdentifier.builder().accountNumber(accountNumber).build()))
                .birthDate(LocalDateTime.now())
                .contacts(List.of(ContactIdentifier.builder().contactId(contactId).build()))
                .creationTime(LocalDateTime.now())
                .documentIdCountry("Portugal")
                .documentIdNumber("37995894 5 ZW6")
                .documentIdType("CC")
                .documentIdExpirationDate(LocalDateTime.now())
                .firstName("Mário Ferreira")
                .isValid(false)
                .lastName("Neves")
                .lastUpdateTime(LocalDateTime.now())
                .nationality("Português")
                .number("C123456789")
                .taxIdCountry("Portugal")
                .taxIdNumber("216875161")
                .taxIdType("CC")
                .type(CustomerType.PARTICULAR.name())
                .build();
    }

    public static CustomerRef buildCustomerRef(Customer customer, String accountNumber){
        return CustomerRef.builder()
                .customerNumber(customer.getNumber())
                .isValid(customer.getIsValid())
                .accounts(List.of(AccountIdentifier.builder().accountNumber(accountNumber).build()))
                .build();
    }

    public static Document buildDoc(String customerNumber, String accountNumber){
        return Document.builder()
                .documentName(DocumentType.CC.getValue())
                .documentType(DocumentType.CC.name())
                .documentBase64("DOCUMENTBASE64TESTSPURPOSES")
                .uploadedTime(LocalDateTime.now())
                .customerNumber(customerNumber)
                .accountNumber(accountNumber)
                .build();
    }

    public static Intervention buildIntervention(String accountNumber, String customerNumber){
        return Intervention.builder()
                .creationTime(LocalDateTime.now())
                .description(InterventionType.G.getValue())
                .lastUpdateTime(LocalDateTime.now())
                .interventionType(InterventionType.G.name())
                .accountNumber(accountNumber)
                .customerNumber(customerNumber)
                .build();
    }

    public static Relation buildRelation(String customerNumber){
        return Relation.builder()
                .creationTime(LocalDateTime.now())
                .childCustomerNumber(customerNumber)
                .description(RelationType.G.getValue())
                .fatherCustomerNumber(customerNumber)
                .lastUpdateTime(LocalDateTime.now())
                .relationType(RelationType.G.name())
                .build();
    }
}
