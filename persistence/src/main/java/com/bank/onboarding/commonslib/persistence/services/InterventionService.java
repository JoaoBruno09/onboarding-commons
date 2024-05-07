package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Intervention;

import java.util.List;

public interface InterventionService {
    List<Intervention> getAllInterventions();
}
