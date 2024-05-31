package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Intervention;

import java.util.List;

public interface InterventionRepoService {
    List<Intervention> getAllInterventions();
    Intervention saveInterventionDB(Intervention intervention);
    void findAndDeleteInterventionByAccountId(String accountId);
}
