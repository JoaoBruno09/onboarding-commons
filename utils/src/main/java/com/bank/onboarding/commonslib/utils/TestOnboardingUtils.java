package com.bank.onboarding.commonslib.utils;

import com.bank.onboarding.commonslib.persistence.enums.AccountPhase;
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
import com.bank.onboarding.commonslib.web.dtos.account.AccountCardDTO;
import com.bank.onboarding.commonslib.web.dtos.account.AccountDeleteCardDTO;
import com.bank.onboarding.commonslib.web.dtos.account.AccountNetbancoDTO;
import com.bank.onboarding.commonslib.web.dtos.account.AccountTypeRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.account.CardDTO;
import com.bank.onboarding.commonslib.web.dtos.account.CreateAccountRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.account.MoveNextPhaseDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.AddressDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.ContactDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CreateIntervenientDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CreateRelationDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerDocumentsRequest;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.DocumentIdDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.TaxIdDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.UpdateCustomerRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.document.DeleteDocumentRequestDTO;
import com.bank.onboarding.commonslib.web.dtos.document.DocumentDTO;
import com.bank.onboarding.commonslib.web.dtos.document.UploadDocumentRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public class TestOnboardingUtils {

    private static final String IBAN = "PT50 0000 2927 8040 8012 4082 5";

    public static Account buildAccount(){

        return Account.builder()
                .accountManager("Mário Ferreira Neves")
                .active(Boolean.FALSE)
                .creationTime(LocalDateTime.now())
                .currencyCode("EUR")
                .iban(IBAN)
                .lastUpdateTime(LocalDateTime.now())
                .number(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .onlineBankingIndicator(Boolean.FALSE)
                .phase(AccountPhase.INTYPE.getValue())
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
                .documentName(DocumentType.CM.getValue())
                .documentType(DocumentType.CM.name())
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

    public static CreateAccountRequestDTO buildCreateAccountRequestDTO(){
        return CreateAccountRequestDTO.builder()
                .accountManager("Mário Ferreira Neves")
                .accountType(AccountType.ORDEM.name())
                .customerIntervenient(buildCustomerRequestDTO())
                .build();
    }

    public static AccountTypeRequestDTO buildAccountTypeRequestDTO(){
        return AccountTypeRequestDTO.builder()
                .accountActive(false)
                .accountType(AccountType.BASE.name())
                .accountPhase(AccountPhase.INTYPE.getValue())
                .customerBirthDate(LocalDateTime.parse("1999-07-24T17:20:33"))
                .customerProfession("Trabalhador dependente")
                .customerType(CustomerType.PARTICULAR.name())
                .build();
    }

    public static AccountCardDTO buildAccountCardDTO(){
         return AccountCardDTO.builder()
                .cardType(CardType.CD.name())
                .customerNumber(List.of("C123456789"))
                .accountPhase(AccountPhase.RELCARD.getValue())
                .build();
    }

    public static CardDTO buildCardDTO(){
        return  CardDTO.builder()
                .annualFee(10)
                .cvc(111)
                .number("1234-5678-9101-1121")
                .type(CardType.CD.name())
                .build();
    }

    public static AccountDeleteCardDTO deleteAccountCardDTO(){
        return AccountDeleteCardDTO.builder()
                .accountPhase(AccountPhase.RELCARD.getValue())
                .customerNumber("C123456789")
                .build();
    }

    public static AccountNetbancoDTO buildAccountNetbancoDTO(){
        return AccountNetbancoDTO.builder()
                .wantsNetbanco(true)
                .accountPhase(AccountPhase.RELCARD.getValue())
                .customerNumber("C123456789")
                .build();
    }

    public static MoveNextPhaseDTO buildMoveNextPhaseDTO(){
        return MoveNextPhaseDTO.builder()
                .nextPhase(AccountPhase.RELCARD.getValue())
                .build();
    }

    public static DeleteDocumentRequestDTO buildDeleteDocumentRequestDTO(){
        return DeleteDocumentRequestDTO.builder()
                .documentType(DocumentType.CM.name())
                .customerNumber("C123456789")
                .accountNumber(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .accountPhase(AccountPhase.DOCS.getValue())
                .build();
    }

    public static UploadDocumentRequestDTO buildUploadDocumentRequestDTO(){
        return UploadDocumentRequestDTO.builder()
                .documentType(DocumentType.CM.name())
                .documentBase64("JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKP")
                .customerNumber("C123456789")
                .accountNumber(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .accountPhase(AccountPhase.DOCS.getValue())
                .build();
    }

    public static DocumentDTO buildDocumentDTO(){
        return DocumentDTO.builder()
                .documentName(DocumentType.CC.getValue())
                .documentType(DocumentType.CC.name())
                .documentBase64("JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKP")
                .build();
    }

    public static CreateRelationDTO buildCreateRelationDTO(){
        return CreateRelationDTO.builder()
                .childCustomerNumber("C123456789")
                .parentCustomer(buildCustomerRequestDTO())
                .accountPhase(AccountPhase.RELCARD.getValue())
                .accountNumber(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .build();
    }

    public static CreateIntervenientDTO buildCreateIntervenientDTO(){
        return CreateIntervenientDTO.builder()
                .intervenient(buildCustomerRequestDTO())
                .accountPhase(AccountPhase.RELCARD.getValue())
                .accountNumber(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .build();
    }

    public static CustomerRequestDTO buildCustomerRequestDTO(){
        return CustomerRequestDTO.builder()
                .customerBirthDate(LocalDateTime.parse("1999-07-24T17:20:33"))
                .customerContact(buildContactDTO())
                .customerDocId(buildDocumentIdDTO())
                .customerTaxId(buildTaxIdDTO())
                .customerFirstName("João")
                .customerLastName("Rocha")
                .customerType(CustomerType.PARTICULAR.name())
                .customerInterventionType(InterventionType.TT.name())
                .customerDocuments(List.of(CustomerDocumentsRequest.builder()
                        .documentType(DocumentType.CC.name())
                        .documentBase64("JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKP")
                        .build()))
                .build();
    }

    public static ContactDTO buildContactDTO(){
        return ContactDTO.builder()
                .type(ContactType.TELEPHONE.getValue())
                .value("963843155")
                .build();
    }

    public static DocumentIdDTO buildDocumentIdDTO(){
        return DocumentIdDTO.builder()
                .documentIdCountry("Portugal")
                .documentIdNumber("18229331 9 ZV8")
                .documentIdType(DocumentType.CC.name())
                .documentIdExpirationDate(LocalDateTime.parse("1999-07-24T17:20:33").plusYears(5))
                .build();
    }

    public static TaxIdDTO buildTaxIdDTO(){
        return TaxIdDTO.builder()
                .taxIdCountry("Portugal")
                .taxIdNumber("297662716")
                .taxIdType(DocumentType.CC.name())
                .build();
    }

    public static AddressDTO buildAddressDTO(){
        return AddressDTO.builder()
                .city("Porto")
                .country("Portugal")
                .street("Rua do Carmo")
                .zip("4050-164")
                .build();
    }

    public static UpdateCustomerRequestDTO buildUpdateCustomerRequestDTO(){
        return UpdateCustomerRequestDTO.builder()
                .addresses(List.of(buildAddressDTO()))
                .annualIncome("50000")
                .birthDate(LocalDateTime.parse("1999-07-24T17:20:33"))
                .contacts(List.of(buildContactDTO()))
                .documentId(buildDocumentIdDTO())
                .educationLevel("Trabalhador independente")
                .fatherName("José Ferreira")
                .firstName("Mário")
                .gender("Masculinho")
                .lastName("Ferreira")
                .motherName("Maria Ferreira")
                .nationality("Português")
                .profession("Engenheiro Civil")
                .taxId(buildTaxIdDTO())
                .accountPhase(AccountPhase.INTYPE.getValue())
                .accountNumber(IBAN.trim().replaceAll(" ", "").substring(IBAN.length()-19))
                .build();
    }
}
