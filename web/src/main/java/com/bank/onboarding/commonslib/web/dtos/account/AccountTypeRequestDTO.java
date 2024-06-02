package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountTypeRequestDTO {
    boolean accountActive;
    String accountType;
    int accountPhase;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime customerBirthDate;
    String customerProfession;
    String customerType;
}
