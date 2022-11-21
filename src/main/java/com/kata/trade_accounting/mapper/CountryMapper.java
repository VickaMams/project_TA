package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.CountryDTO;
import com.kata.trade_accounting.model.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDTO toDto(Country country);

    Country dtoToModel(CountryDTO countryDTO);
}
