package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.NdsDto;
import com.kata.trade_accounting.model.Nds;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface NdsMapper extends Converter<NdsDto, Nds> {
    Nds toNds(NdsDto ndsDto);
}
