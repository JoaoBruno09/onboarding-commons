package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Intervention;

import java.util.List;

public interface InterventionRepoService {
    List<Intervention> getAllInterventionsByCustomerNumber(String customerNumber);
    Intervention saveInterventionDB(Intervention intervention);
    void findAndDeleteInterventionByAccountNumber(String accountNumber);
    Intervention getInterventionByInterventionId(String interventionId);
    void deleteIntervention(Intervention intervention);
}
