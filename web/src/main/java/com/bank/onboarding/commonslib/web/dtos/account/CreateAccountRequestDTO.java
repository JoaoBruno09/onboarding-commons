package com.bank.onboarding.commonslib.web.dtos.account;

import com.bank.onboarding.commonslib.web.dtos.customer.CustomerDocumentsRequest;
import com.bank.onboarding.commonslib.web.dtos.customer.ContactDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.DocumentIdDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.TaxIdDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateAccountRequestDTO {
    String accountManager;
    String accountType;
    LocalDateTime customerBirthDate;
    ContactDTO customerContact;
    DocumentIdDTO customerDocId;
    TaxIdDTO customerTaxId;
    String customerFirstName;
    String customerLastName;
    String customerType;
    String customerInterventionType;
    List<CustomerDocumentsRequest> customerDocuments;
}
