package com.bank.onboarding.commonslib.web.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CustomerDTO {
    @Valid
    private List<AddressDTO> addresses;
    @NotEmpty
    private String annualIncome;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime birthDate;
    private Boolean cardIndicator;
    @Valid
    private List<ContactDTO> contacts;
    @Valid
    private DocumentIdDTO documentId;
    @NotEmpty
    private String educationLevel;
    @NotEmpty
    private String fatherName;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String gender;
    private Boolean intervenientIndicator;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String motherName;
    @NotEmpty
    private String nationality;
    @NotEmpty
    private String number;
    private Boolean onlineBankingIndicator;
    @NotEmpty
    private String profession;
    private Boolean relationIndicator;
    @Valid
    private TaxIdDTO taxId;
    @NotEmpty
    private String type;
}
