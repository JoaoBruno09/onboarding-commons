package com.bank.onboarding.commonslib.web.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CustomerRequestDTO {
    private LocalDateTime customerBirthDate;
    private ContactDTO customerContact;
    private DocumentIdDTO customerDocId;
    private TaxIdDTO customerTaxId;
    private String customerFirstName;
    private String customerLastName;
    private String customerType;
    private String customerInterventionType;
    private String customerRelationType;
    private List<CustomerDocumentsRequest> customerDocuments;
}
