package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildAccount;
import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildContact;
import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildCustomer;

@SpringBootTest(classes = Application.class)
class CustomerRepositoryUnitTests {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		contactRepository.deleteAll();
		customerRepository.deleteAll();
		accountRepository.deleteAll();
	}

	@Test
	void saveCustomerTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customerBuilt = buildCustomer(account.getNumber(), contact.getId());

		Customer customerSaved = customerRepository.save(customerBuilt);

		Assertions.assertThat(customerSaved).isNotNull();
		Assertions.assertThat(customerSaved.getId()).isNotEmpty();
		Assertions.assertThat(customerSaved).isEqualTo(customerBuilt);
	}

	@Test
	void findByNumber() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customerSaved = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));

		Customer customerSearched = customerRepository.findByNumber(customerSaved.getNumber());

		Assertions.assertThat(customerSearched).isNotNull();
		Assertions.assertThat(customerSearched.getId()).isNotEmpty();
		Assertions.assertThat(customerSearched.getId()).isEqualTo(customerSaved.getId());
	}

	@Test
	void deleteByNumber() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customerSaved = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));

		customerRepository.deleteByNumber(customerSaved.getNumber());

		Assertions.assertThat(customerRepository.findById(customerSaved.getId())).isEmpty();
	}

	@Test
	void findAllByNumber() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customerSaved = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));

		List<Customer> customerSearched = customerRepository.findAllByNumber(customerSaved.getNumber());

		Assertions.assertThat(customerSearched).isNotEmpty();
	}
}
