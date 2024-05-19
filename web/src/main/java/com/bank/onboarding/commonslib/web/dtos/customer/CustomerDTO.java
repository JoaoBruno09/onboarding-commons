package com.bank.onboarding.commonslib.web.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CustomerDTO {
    private List<AddressDTO> addresses;
    private String annualIncome;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime birthDate;
    private Boolean cardIndicator;
    private List<ContactDTO> contacts;
    private DocumentIdDTO documentId;
    private String educationLevel;
    private String fatherName;
    private String firstName;
    private String gender;
    private Boolean intervenientIndicator;
    private String lastName;
    private String motherName;
    private String nationality;
    private String number;
    private Boolean onlineBankingIndicator;
    private String profession;
    private Boolean relationIndicator;
    private TaxIdDTO taxId;
    private String type;
}
