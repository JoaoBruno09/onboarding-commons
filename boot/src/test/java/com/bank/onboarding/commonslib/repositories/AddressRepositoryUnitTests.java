package com.bank.onboarding.commonslib.repositories;

import com.bank.onboarding.commonslib.boot.Application;
import com.bank.onboarding.commonslib.persistence.models.Address;
import com.bank.onboarding.commonslib.persistence.repositories.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bank.onboarding.commonslib.TestOnboardingUtils.buildAddress;

@SpringBootTest(classes = Application.class)
class AddressRepositoryUnitTests {

	@Autowired
	private AddressRepository addressRepository;

	@BeforeEach
	public void cleanDatabase() {
		addressRepository.deleteAll();
	}

	@Test
	void saveAddressTest() {
		//ARRANGE
		Address address = buildAddress();

		//ACT
		Address addressSaved = addressRepository.save(address);

		//ASSERT
		Assertions.assertThat(addressSaved).isNotNull();
		Assertions.assertThat(addressSaved.getId()).isNotEmpty();
		Assertions.assertThat(addressSaved).isEqualTo(address);
	}
}
