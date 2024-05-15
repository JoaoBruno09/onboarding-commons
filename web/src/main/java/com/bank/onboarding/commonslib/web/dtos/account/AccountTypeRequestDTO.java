package com.bank.onboarding.commonslib.web.dtos.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountTypeRequestDTO {
    private boolean accountActive;
    private String accountType;
    private int accountPhase;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime customerBirthDate;
    private String customerProfession;
    private String customerType;
}
