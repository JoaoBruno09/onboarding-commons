package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.Relation;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import com.bank.onboarding.commonslib.persistence.repositories.RelationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildAccount;
import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildContact;
import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildCustomer;
import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildRelation;

@SpringBootTest(classes = Application.class)
class RelationRepositoryUnitTests {

	@Autowired
	private RelationRepository relationRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		relationRepository.deleteAll();
		contactRepository.deleteAll();
		customerRepository.deleteAll();
		accountRepository.deleteAll();
	}

	@Test
	void saveRelationTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Relation relationBuilt = buildRelation(customer.getNumber());

		Relation relationSaved = relationRepository.save(relationBuilt);

		Assertions.assertThat(relationSaved).isNotNull();
		Assertions.assertThat(relationSaved.getId()).isNotEmpty();
		Assertions.assertThat(relationSaved).isEqualTo(relationBuilt);
	}

	@Test
	void findAllByFatherCustomerNumber() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Relation relationSaved = relationRepository.save(buildRelation(customer.getNumber()));

		List<Relation> relationsSearched = relationRepository.findAllByFatherCustomerNumber(relationSaved.getFatherCustomerNumber());

		Assertions.assertThat(relationsSearched).isNotEmpty();
	}
}
