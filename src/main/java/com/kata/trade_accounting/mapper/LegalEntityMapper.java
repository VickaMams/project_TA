package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.LegalEntityRequestDto;
import com.kata.trade_accounting.model.LegalEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LegalEntityMapper extends Converter<LegalEntityRequestDto, LegalEntity> {
    LegalEntity toLegalEntity(LegalEntityRequestDto legalEntityRequestDto);
}
