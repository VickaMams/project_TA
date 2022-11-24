package com.kata.trade_accounting.controller.mapper;

import com.kata.trade_accounting.dto.LawDetailsDTO;
import com.kata.trade_accounting.model.LawDetails;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LawDetailsMapper {

    private final ModelMapper mapper;

    public LawDetailsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public LawDetailsDTO toDto(LawDetails lawDetails) {
        return mapper.map(lawDetails, LawDetailsDTO.class);
    }

    public LawDetails toEntity(LawDetailsDTO dto) {
        return mapper.map(dto, LawDetails.class);
    }
}
