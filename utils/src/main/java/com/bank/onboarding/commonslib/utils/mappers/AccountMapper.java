package com.bank.onboarding.commonslib.utils.mappers;

import com.bank.onboarding.commonslib.persistence.models.Account;
import com.bank.onboarding.commonslib.persistence.models.AccountRef;
import com.bank.onboarding.commonslib.persistence.models.Card;
import com.bank.onboarding.commonslib.web.dtos.account.AccountDTO;
import com.bank.onboarding.commonslib.web.dtos.account.AccountRefDTO;
import com.bank.onboarding.commonslib.web.dtos.account.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    AccountDTO toAccountDTO(Account account);
    CardDTO toCardDTO(Card card);
    @Mapping(target = "id", source = "accountId")
    AccountRef toAccountRef(AccountRefDTO accountRefDTO);
}
