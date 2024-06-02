package com.bank.onboarding.commonslib.utils.mappers;

import com.bank.onboarding.commonslib.persistence.models.Customer;
import com.bank.onboarding.commonslib.persistence.models.CustomerRef;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerDTO;
import com.bank.onboarding.commonslib.web.dtos.customer.CustomerRefDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(target = "id", source = "customerId")
    CustomerRef toCustomerRef(CustomerRefDTO customerRefDTO);

    @Mapping(target = "documentId.documentIdCountry", source = "documentIdCountry")
    @Mapping(target = "documentId.documentIdNumber", source = "documentIdNumber")
    @Mapping(target = "documentId.documentIdType", source = "documentIdType")
    @Mapping(target = "documentId.documentIdExpirationDate", source = "documentIdExpirationDate")
    @Mapping(target = "taxId.taxIdCountry", source = "taxIdCountry")
    @Mapping(target = "taxId.taxIdNumber", source = "taxIdNumber")
    @Mapping(target = "taxId.taxIdType", source = "taxIdType")
    @Mapping(ignore = true, target = "addresses")
    @Mapping(ignore = true, target = "contacts")
    CustomerDTO toCustomerDTO(Customer customer);
}
