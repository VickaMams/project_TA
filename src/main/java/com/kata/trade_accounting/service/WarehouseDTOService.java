package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseDTOService {
    List<WarehouseDTO> findAll();

    WarehouseDTO findById(Long id);

    WarehouseDTO save(WarehouseDTO wareHouseDTO);

    void deleteById(Long id);

    WarehouseDTO update(WarehouseDTO wareHouseDTO);
}
