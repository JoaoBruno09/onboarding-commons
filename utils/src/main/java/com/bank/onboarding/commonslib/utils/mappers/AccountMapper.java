package com.bank.onboarding.commonslib.utils.mappers;

import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.web.dtos.account.AccountDTO;
import com.bank.onboarding.commonslib.web.dtos.account.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    @Mapping(target="accountCurrencyCode", source="currencyCode")
    @Mapping(target="accountIban", source="iban")
    @Mapping(target="accountNumber", source="number")
    @Mapping(target="accountOnlineBankingIndicator", source="onlineBankingIndicator")
    @Mapping(target="accountType", source="type")
    AccountDTO toAccountDTO(Account account);

    @Mapping(target="cardAnnualFee", source="annualFee")
    @Mapping(target="cardCvc", source="cvc")
    @Mapping(target="cardNumber", source="number")
    @Mapping(target="cardType", source="type")
    CardDTO toCardDTO(Card card);
}
