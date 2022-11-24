package com.kata.trade_accounting.controller.mapper;

import com.kata.trade_accounting.dto.WarehouseDTO;
import com.kata.trade_accounting.model.Warehouse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper {
    private final ModelMapper mapper;

    public WarehouseMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public WarehouseDTO toDto(Warehouse warehouse) {
        return mapper.map(warehouse, WarehouseDTO.class);
    }

    public Warehouse toEntity(WarehouseDTO dto) {
        return mapper.map(dto, Warehouse.class);
    }
}
