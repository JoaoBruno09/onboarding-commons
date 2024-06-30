package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.Document;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CustomerRepository;
import com.bank.onboarding.commonslib.persistence.repositories.DocumentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildAccount;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildContact;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildCustomer;
import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildDoc;

@SpringBootTest(classes = Application.class)
class DocumentRepositoryTests {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		documentRepository.deleteAll();
		contactRepository.deleteAll();
		customerRepository.deleteAll();
		accountRepository.deleteAll();
	}

	@Test
	void saveDocumentTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Document documentBuilt = buildDoc(customer.getNumber(), null);

		Document documentSaved = documentRepository.save(documentBuilt);

		Assertions.assertThat(documentSaved).isNotNull();
		Assertions.assertThat(documentSaved.getId()).isNotEmpty();
		Assertions.assertThat(documentSaved).isEqualTo(documentBuilt);
	}

	@Test
	void findByAccountNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Document documentSaved = documentRepository.save(buildDoc(null, account.getNumber()));

		Document documentSearched = documentRepository.findByAccountNumber(documentSaved.getAccountNumber());

		Assertions.assertThat(documentSearched).isNotNull();
		Assertions.assertThat(documentSearched.getId()).isNotEmpty();
		Assertions.assertThat(documentSearched.getId()).isEqualTo(documentSaved.getId());
	}

	@Test
	void findByCustomerNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Document documentSaved = documentRepository.save(buildDoc(customer.getNumber(), null));

		Document documentSearched = documentRepository.findByCustomerNumber(documentSaved.getCustomerNumber());

		Assertions.assertThat(documentSearched).isNotNull();
		Assertions.assertThat(documentSearched.getId()).isNotEmpty();
		Assertions.assertThat(documentSearched.getId()).isEqualTo(documentSaved.getId());
	}

	@Test
	void findAllByAccountNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Document documentSaved = documentRepository.save(buildDoc(null, account.getNumber()));

		List<Document> documentsSearched = documentRepository.findAllByAccountNumber(documentSaved.getAccountNumber());

		Assertions.assertThat(documentsSearched).isNotEmpty();
	}

	@Test
	void findAllByCustomerNumberTest() {
		Account account = accountRepository.save(buildAccount());
		Contact contact = contactRepository.save(buildContact());
		Customer customer = customerRepository.save(buildCustomer(account.getNumber(), contact.getId()));
		Document documentSaved = documentRepository.save(buildDoc(customer.getNumber(), null));

		List<Document> documentsSearched = documentRepository.findAllByCustomerNumber(documentSaved.getCustomerNumber());

		Assertions.assertThat(documentsSearched).isNotEmpty();
	}

}
