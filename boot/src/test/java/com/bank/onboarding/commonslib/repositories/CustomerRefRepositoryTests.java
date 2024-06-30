package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRefRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildAccount;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildContact;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildCustomer;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildCustomerRef;

@SpringBootTest(classes = Application.class)
class CustomerRefRepositoryTests {

	@Autowired
	private CustomerRefRepository customerRefRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		customerRefRepository.deleteAll();
		contactRepository.deleteAll();
		customerRepository.deleteAll();
		accountRepository.deleteAll();
	}

	@Test
	void saveCustomerRefTest(){
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		CustomerRef customerRef = customerRefRepository.save(buildCustomerRef(customer, account.getNumber()));

		CustomerRef customerRefSaved = customerRefRepository.save(customerRef);

		Assertions.assertThat(customerRefSaved).isNotNull();
		Assertions.assertThat(customerRefSaved.getId()).isNotEmpty();
		Assertions.assertThat(customerRefSaved).isEqualTo(customerRef);
	}

	@Test
	void findByCustomerNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		customerRefRepository.save(buildCustomerRef(customer, account.getNumber()));

		CustomerRef customerRefSearched = customerRefRepository.findByCustomerNumber(customer.getNumber());

		Assertions.assertThat(customerRefSearched).isNotNull();
		Assertions.assertThat(customerRefSearched.getId()).isNotEmpty();
		Assertions.assertThat(customerRefSearched.getCustomerNumber()).isEqualTo(customer.getNumber());
	}

	@Test
	void deleteByCustomerNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		CustomerRef customerRef = customerRefRepository.save(buildCustomerRef(customer, account.getNumber()));

		customerRefRepository.deleteByCustomerNumber(customerRef.getCustomerNumber());

		Assertions.assertThat(customerRefRepository.findById(customerRef.getId())).isEmpty();
	}

	@Test
	void findAllByAccountsAccountNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		customerRefRepository.save(buildCustomerRef(customer, account.getNumber()));

		List<CustomerRef> customerRefsSearched = customerRefRepository.findAllByAccountsAccountNumber(account.getNumber());

		Assertions.assertThat(customerRefsSearched).isNotEmpty();
	}

}
