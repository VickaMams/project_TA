package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.WareHouseDTO;
import com.kata.trade_accounting.model.WareHouse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WareHouseMapper {
    private final ModelMapper mapper;

    public WareHouseMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public WareHouseDTO toDto(WareHouse lawDetails) {
        return mapper.map(lawDetails, WareHouseDTO.class);
    }

    public WareHouse toEntity(WareHouseDTO dto) {
        return mapper.map(dto, WareHouse.class);
    }
}
