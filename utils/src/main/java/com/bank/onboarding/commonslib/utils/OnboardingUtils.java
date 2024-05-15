package com.bank.onboarding.commonslib.utils;

import java.time.LocalDateTime;

public interface OnboardingUtils {
    boolean isEmpresaAccountType(String accountType);
    boolean isParticularAccountType(String accountType);
    Boolean isMinorAndHasProgenitorOrTutorAndAccountTypeIsJOV(int age, String customerType);
    Boolean isMajorAndUniversityStudentAndAccountTypeIsUNIV(Integer age, String customerProfession, String customerType);
    int calculateAge(LocalDateTime birthDate);
}
