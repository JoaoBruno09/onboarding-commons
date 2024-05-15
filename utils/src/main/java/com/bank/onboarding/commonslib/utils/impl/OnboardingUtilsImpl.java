package com.bank.onboarding.commonslib.utils.impl;

import com.bank.onboarding.commonslib.persistence.repositories.CardRepository;
import com.bank.onboarding.commonslib.utils.OnboardingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.EMPRESA_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.MINOR_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.PARTICULAR_ACCOUNT_TYPES;
import static com.bank.onboarding.commonslib.persistence.constants.OnboardingConstants.STUDENT_ACCOUNT_TYPES;


@Service
@Transactional
@RequiredArgsConstructor
public class OnboardingUtilsImpl implements OnboardingUtils {

    private final CardRepository cardRepository;

    @Override
    public boolean isEmpresaAccountType(String accountType) {
        return EMPRESA_ACCOUNT_TYPES.contains(accountType);
    }

    @Override
    public boolean isParticularAccountType(String accountType) {
        return PARTICULAR_ACCOUNT_TYPES.contains(accountType);
    }

    @Override
    public Boolean isMinorAndHasProgenitorOrTutorAndAccountTypeIsJOV(int age, String customerType) {
        return age < 17 && MINOR_ACCOUNT_TYPES.contains(customerType);
    }

    @Override
    public Boolean isMajorAndUniversityStudentAndAccountTypeIsUNIV(Integer age, String customerProfession, String customerType) {
        return age >= 17 && "Estudante Universitário".equals(Optional.ofNullable(customerProfession).orElse("")) &&
                STUDENT_ACCOUNT_TYPES.contains(customerType);
    }

    @Override
    public int calculateAge(LocalDateTime birthDate) {
        return Period.between(birthDate.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
    }
}
