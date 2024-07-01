package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildContact;

@SpringBootTest(classes = Application.class)
class ContactRepositoryUnitTests {

	@Autowired
	private ContactRepository contactRepository;

	@BeforeEach
	public void cleanDatabase() {
		contactRepository.deleteAll();
	}

	@Test
	void saveContactTest() {

		//ARRANGE
		Contact contact = buildContact();

		//ACT
		Contact contactSaved = contactRepository.save(contact);

		//ASSERT
		Assertions.assertThat(contactSaved).isNotNull();
		Assertions.assertThat(contactSaved.getId()).isNotEmpty();
		Assertions.assertThat(contactSaved).isEqualTo(contact);
	}
}
