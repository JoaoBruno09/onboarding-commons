package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class AccountTypeRequestDTO {
    @NotNull
    boolean accountActive;
    @NotNull
    @NotBlank
    String accountType;
    @NotNull
    int accountPhase;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime customerBirthDate;
    @NotBlank
    @NotNull
    String customerProfession;
    @NotBlank
    @NotNull
    String customerType;
}
