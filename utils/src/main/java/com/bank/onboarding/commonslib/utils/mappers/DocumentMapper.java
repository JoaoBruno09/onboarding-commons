package com.bank.onboarding.commonslib.utils.mappers;

import com.bank.onboarding.commonslib.persistence.models.Document;
import com.bank.onboarding.commonslib.web.dtos.document.DocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper( DocumentMapper.class );

    DocumentDTO toDocumentDTO(Document document);
}