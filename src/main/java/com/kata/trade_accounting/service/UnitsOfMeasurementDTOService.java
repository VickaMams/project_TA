package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.UnitsOfMeasurementDTO;

import java.util.List;

public interface UnitsOfMeasurementDTOService {
    List<UnitsOfMeasurementDTO> findAll();

    UnitsOfMeasurementDTO findById(Long id);

    UnitsOfMeasurementDTO save(UnitsOfMeasurementDTO wareHouseDTO);

    void deleteById(Long id);

    UnitsOfMeasurementDTO update(UnitsOfMeasurementDTO wareHouseDTO);
}
