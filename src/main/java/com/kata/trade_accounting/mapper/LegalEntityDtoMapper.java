package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.LegalEntityRresponseDto;
import com.kata.trade_accounting.model.LegalEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LegalEntityDtoMapper extends Converter<LegalEntity, LegalEntityRresponseDto> {

    LegalEntityRresponseDto toLegalEntityDto(LegalEntity legalEntity);
}
