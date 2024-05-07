package com.bank.onboarding.commonslib.persistence.services;

import com.bank.onboarding.commonslib.persistence.models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
}
