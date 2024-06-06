package com.bank.onboarding.commonslib.web.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UpdateCustomerRequestDTO {
    @NotEmpty
    private List<AddressDTO> addresses;
    @NotBlank
    private String annualIncome;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @NotBlank
    @NotNull
    private LocalDateTime birthDate;
    @NotEmpty
    private List<ContactDTO> contacts;
    @NotNull
    private DocumentIdDTO documentId;
    @NotBlank
    private String educationLevel;
    @NotBlank
    private String fatherName;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    private String gender;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    private String motherName;
    @NotBlank
    private String nationality;
    @NotBlank
    private String profession;
    @NotNull
    private TaxIdDTO taxId;
    @NotNull
    private int accountPhase;
}
