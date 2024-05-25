package com.bank.onboarding.commonslib.utils.mappers;

import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    @Mapping(target = "id", source = "customerId")
    CustomerRef toCustomerRef(CustomerRefDTO customerRefDTO);
}
