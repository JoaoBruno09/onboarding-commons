package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountTypeRequestDTO {
    @NotNull
    boolean accountActive;
    @NotNull
    @NotBlank
    String accountType;
    @NotNull
    int accountPhase;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @NotNull
    @NotBlank
    LocalDateTime customerBirthDate;
    @NotBlank
    @NotNull
    String customerProfession;
    @NotBlank
    @NotNull
    String customerType;
}
