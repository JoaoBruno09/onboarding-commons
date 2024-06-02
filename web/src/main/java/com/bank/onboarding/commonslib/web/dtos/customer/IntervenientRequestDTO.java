package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class IntervenientRequestDTO {
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
