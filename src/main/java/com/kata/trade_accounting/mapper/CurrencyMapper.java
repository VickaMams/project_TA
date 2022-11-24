package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.CurrencyDTO;
import com.kata.trade_accounting.model.Currency;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CurrencyMapper {

    private final ModelMapper mapper;

    public CurrencyDTO toDto(Currency currency) {
        return  mapper.map(currency, CurrencyDTO.class);
    }

    public Currency toEntity(CurrencyDTO dto) {
        return mapper.map(dto, Currency.class);
    }
}
