package com.kata.trade_accounting.controller.mapper;

import com.kata.trade_accounting.dto.UnitsOfMeasurementDTO;
import com.kata.trade_accounting.model.UnitsOfMeasurement;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UnitsOfMeasurementMapper {
    private final ModelMapper mapper;

    public UnitsOfMeasurementMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UnitsOfMeasurementDTO toDto(UnitsOfMeasurement unitsOfMeasurement) {
        return mapper.map(unitsOfMeasurement, UnitsOfMeasurementDTO.class);
    }

    public UnitsOfMeasurement toEntity(UnitsOfMeasurementDTO dto) {
        return mapper.map(dto, UnitsOfMeasurement.class);
    }
}
