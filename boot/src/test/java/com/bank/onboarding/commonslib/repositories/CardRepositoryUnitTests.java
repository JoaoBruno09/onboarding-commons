package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.persistence.models.Contact;
import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import com.bank.onboarding.commonslib.persistence.repositories.CardRepository;
import com.bank.onboarding.commonslib.persistence.repositories.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.builCard;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildAccount;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildContact;
import static com.bank.onboarding.commonslib.utils.TestOnboardingUtils.buildCustomer;

@SpringBootTest(classes = Application.class)
class CardRepositoryUnitTests {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ContactRepository contactRepository;

	@BeforeEach
	public void cleanDatabase() {
		cardRepository.deleteAll();
		accountRepository.deleteAll();
		contactRepository.deleteAll();
	}


	@Test
	void saveCardTest() {
		//ARRANGE
		Card card = builCard();

		//ACT
		Card cardSaved = cardRepository.save(card);

		//ASSERT
		Assertions.assertThat(cardSaved).isNotNull();
		Assertions.assertThat(cardSaved.getId()).isNotEmpty();
		Assertions.assertThat(cardSaved).isEqualTo(card);
	}
	@Test
	void findByNumberTest() {
		Card card = builCard();

		Account account = buildAccount();
		accountRepository.save(account);

		Contact contact = buildContact();
		contactRepository.save(contact);

		Customer customer = buildCustomer(account.getNumber(), contact.getId());

		card.setAccountId(account.getId());
		card.setCustomerNumber(customer.getNumber());
		cardRepository.save(card);
		Card cardReturned = cardRepository.findByNumber(card.getNumber());

		Assertions.assertThat(cardReturned).isNotNull();
		Assertions.assertThat(cardReturned.getId()).isNotEmpty();
		Assertions.assertThat(cardReturned).isEqualTo(card);
	}

	@Test
	void findByCustomerNumberAndAccountIdTest() {
		Card card = builCard();

		Account account = buildAccount();
		accountRepository.save(account);

		Contact contact = buildContact();
		contactRepository.save(contact);

		Customer customer = buildCustomer(account.getNumber(), contact.getId());

		card.setAccountId(account.getId());
		card.setCustomerNumber(customer.getNumber());
		cardRepository.save(card);
		Card cardReturned = cardRepository.findByCustomerNumberAndAccountId(card.getCustomerNumber(), card.getAccountId());

		Assertions.assertThat(cardReturned).isNotNull();
		Assertions.assertThat(cardReturned.getId()).isNotEmpty();
		Assertions.assertThat(cardReturned).isEqualTo(card);
	}

	@Test
	void findAllByAccountIdTest() {
		Card card = builCard();
		cardRepository.save(card);
		List<Card> cardsReturned =  cardRepository.findAllByAccountId(card.getAccountId());

		Assertions.assertThat(cardsReturned).isNotEmpty();
	}
}
