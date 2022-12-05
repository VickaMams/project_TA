package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.AccountingTypeDTO;
import com.kata.trade_accounting.model.AccountingType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountingTypeMapper {

    private final ModelMapper mapper;

    public AccountingTypeDTO toDto(AccountingType accountingType) {
        return mapper.map(accountingType, AccountingTypeDTO.class);
    }

    public AccountingType toEntity(AccountingTypeDTO dto) {
        return mapper.map(dto, AccountingType.class);
    }
}
