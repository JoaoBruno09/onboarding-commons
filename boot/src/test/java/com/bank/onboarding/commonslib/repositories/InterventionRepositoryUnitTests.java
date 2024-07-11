package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.Intervention;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import com.bank.onboarding.commonslib.persistence.repositories.InterventionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildAccount;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildContact;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildCustomer;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildIntervention;

@SpringBootTest(classes = Application.class)
class InterventionRepositoryUnitTests {

	@Autowired
	private InterventionRepository interventionRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		interventionRepository.deleteAll();
		contactRepository.deleteAll();
		customerRepository.deleteAll();
		accountRepository.deleteAll();
	}

	@Test
	void saveInterventionTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Intervention interventionBuilt = interventionRepository.save(buildIntervention(account.getNumber(), customer.getNumber()));

		Intervention interventionSaved = interventionRepository.save(interventionBuilt);

		Assertions.assertThat(interventionSaved).isNotNull();
		Assertions.assertThat(interventionSaved.getId()).isNotEmpty();
		Assertions.assertThat(interventionSaved).isEqualTo(interventionBuilt);
	}

	@Test
	void findAllByCustomerNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		interventionRepository.save(buildIntervention(account.getNumber(), customer.getNumber()));

		List<Intervention> interventionsSearched = interventionRepository.findAllByCustomerNumber(customer.getNumber());

		Assertions.assertThat(interventionsSearched).isNotEmpty();
	}

	@Test
	void findByAccountNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Intervention interventionSaved = interventionRepository.save(buildIntervention(account.getNumber(), customer.getNumber()));

		Intervention interventionSearched = interventionRepository.findByAccountNumber(account.getNumber());

		Assertions.assertThat(interventionSearched).isNotNull();
		Assertions.assertThat(interventionSearched.getId()).isNotEmpty();
		Assertions.assertThat(interventionSearched.getId()).isEqualTo(interventionSaved.getId());
	}

}
