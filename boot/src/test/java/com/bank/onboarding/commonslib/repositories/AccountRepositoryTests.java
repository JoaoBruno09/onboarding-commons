package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.repositories.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bank.onboarding.commonslib.OnboardingUtilsTests.buildAccount;

@SpringBootTest(classes = Application.class)
class AccountRepositoryTests {

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void cleanDatabase() {
		accountRepository.deleteAll();
	}

	@Test
	void saveAccountTest() {

		//ARRANGE
		Account account = buildAccount();

		//ACT
		Account accountSaved = accountRepository.save(account);

		//ASSERT
		Assertions.assertThat(accountSaved).isNotNull();
		Assertions.assertThat(accountSaved.getId()).isNotEmpty();
		Assertions.assertThat(accountSaved).isEqualTo(account);
	}

	@Test
	void findAccountByNumberTest() {
		Account account = buildAccount();
		accountRepository.save(account);
		Account accountSearched = accountRepository.findByNumber(account.getNumber());

		Assertions.assertThat(accountSearched).isNotNull();
		Assertions.assertThat(accountSearched.getId()).isNotEmpty();
		Assertions.assertThat(accountSearched.getNumber()).isEqualTo(account.getNumber());
	}

	@Test
	void deleteAccountByNumberTest() {
		Account account = buildAccount();
		account = accountRepository.save(account);
		accountRepository.deleteByNumber(account.getNumber());

		Assertions.assertThat(accountRepository.findById(account.getId())).isEmpty();
	}

	@Test
	void findAllAccountsByIbanTest() {
		Account account = buildAccount();
		accountRepository.save(account);
		List<Account> accountsSearched = accountRepository.findAllByIban(account.getIban());

		Assertions.assertThat(accountsSearched).isNotEmpty();
	}
}
